package net.cavitos.media.player.lib.discid;

import java.io.File;

import com.sun.jna.Pointer;
import com.sun.jna.Native;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscId {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiscId.class);

    private static LibDiscId libDiscId = null;
    private Pointer disc = null;    

    /**
     * Loads the library only when it is not already loaded and allocates a
     * local disc object;
     *
     *
     * @param path path to libdiscid library
     * @return <code>true</code> if successful else <code>false</code>
     */
    public synchronized boolean init(String path) {

        if (!new File(path).exists()) {

            LOGGER.error("File: {} does not exist", path);
            return false;

        } 

        if (libDiscId == null) {

            try {

                // libDiscId = (LibDiscId) Native.loadLibrary(path, LibDiscId.class);
                libDiscId = (LibDiscId) Native.loadLibrary(LibDiscId.class);

            } catch (Throwable ex) {

                LOGGER.error("Check you running are the correct library for your architecture: 64 or 32 bit", ex);
            }
        }

        if (libDiscId != null && disc == null) {

            disc = disc = libDiscId.discid_new();
        }

        return libDiscId != null;
    }

    /**
     * Reads the disc and generates a MusicBrainz DiscId
     *
     * @param drive path to the drive with the audio CD
     * @return the MusicBrainz DiscId or <code>null</code> if unsuccessful
     */
    public String getDiscId(String drive) {

        boolean success = libDiscId.discid_read(disc, drive);

        if (!success) {

            LOGGER.error(libDiscId.discid_get_error_msg(disc).getString(0));

            return "";

        } 

        return libDiscId.discid_get_id(disc).getString(0);
    }

    /**
     * Reads the disc and generates a FreeDB DiscId
     *
     * @param drive path to the drive with the audio CD
     * @return the FreeDB DiscId or <code>null</code> if unsuccessful
     */
    public String getFreeDBId(String drive) {
        String ret = null;
        boolean success = libDiscId.discid_read(disc, drive);
        if (!success) {
            LOGGER.error(libDiscId.discid_get_error_msg(disc).getString(0));
        } else {
            ret = libDiscId.discid_get_freedb_id(disc).getString(0);
        }
        return ret;
    }

    /**
     * Reads the drive and generates a MusicBrainz submittion url
     *
     * @param drive path to the drive with the audio CD
     * @return the MusicBrainz submition url or <code>null</code> if
     * unsuccessful
     */
    public String getSubmissionUrl(String drive) {
        String ret = null;
        boolean success = libDiscId.discid_read(disc, drive);
        if (!success) {
            LOGGER.error(libDiscId.discid_get_error_msg(disc).getString(0));
        } else {
            ret = libDiscId.discid_get_submission_url(disc).getString(0);
        }
        return ret;

    }

    /**
     * Reads the drive and generates a MusicBrainz DiscId lookup url.
     *
     * @param drive path to the drive with the audio CD
     * @return the MusicBrainz discId lookup url or <code>null</code> if
     * unsuccessful
     */
    public String getDiscIdLookupUrl(String drive) {
        String ret = null;
        String discId = getDiscId(drive);
        String toc = getSubmissionUrl(drive);
        if (discId != null && toc != null) {
            toc = toc.substring(toc.indexOf('&'));
            ret = "http://www.musicbrainz.org/ws/2/discid/" + discId + "?" + toc;
        }
        return ret;
    }

    @Override
    protected void finalize() {
        if (null != disc) {
            libDiscId.discid_free(disc);
            disc = null;
        }
    }    
}
