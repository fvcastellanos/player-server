package net.cavitos.media.player.service;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import uk.co.caprica.vlcj.player.base.MediaPlayer;

@Component
public class AudioCdPlayerService {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(AudioCdPlayerService.class);

    private final MediaPlayer mediaPlayer;
    private final String mediaPath;

    @Autowired
    public AudioCdPlayerService(@Value("${media.path}") String mediaPath,
                                final MediaPlayer mediaPlayer) {

        this.mediaPlayer = mediaPlayer;
        this.mediaPath = mediaPath;
    }

    public void prepare() {

        LOGGER.info("Prepare media from: {}", mediaPath);

        var prepared = mediaPlayer.media()
            .prepare(mediaPath, ":disc-caching=300");

        LOGGER.info("Media prepared: {}", prepared);

        if (prepared) {

            mediaPlayer.controls().play();
        }
    }

    public void stop() {

        mediaPlayer.controls()
            .stop();
    }

    @PreDestroy
    public void destroy() {

        LOGGER.info("Release VLC resources");

        mediaPlayer.controls()
            .stop();

        mediaPlayer.release();
    }
}
