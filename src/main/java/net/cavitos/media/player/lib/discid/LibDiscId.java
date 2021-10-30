package net.cavitos.media.player.lib.discid;

import com.sun.jna.Library;
import com.sun.jna.Pointer;

public interface LibDiscId extends Library {
    
    Pointer discid_new();
    void discid_free(Pointer disc);
    boolean discid_read(Pointer disc, String drive);
    Pointer discid_get_id(Pointer disc);
    Pointer discid_get_freedb_id(Pointer disc);
    Pointer discid_get_submission_url(Pointer disc);
    Pointer discid_get_default_device();
    Pointer discid_get_error_msg(Pointer disc);        
}
