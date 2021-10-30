package net.cavitos.media.player.observer.player;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.cavitos.media.player.observer.Observer;
import net.cavitos.media.player.observer.Subject;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;

@Component
public class MediaParseObserver implements Observer {

    private final static Logger LOGGER = LoggerFactory.getLogger(MediaParseObserver.class);

    private final Subject mediaParseSubject;
    private final MediaPlayer mediaPlayer;
    private final MediaListPlayer mediaListPlayer;

    @Autowired
    public MediaParseObserver(final Subject mediaParseSubject,
                              final MediaPlayer mediaPlayer,
                              final MediaListPlayer mediaListPlayer) {

        this.mediaParseSubject = mediaParseSubject;
        this.mediaPlayer = mediaPlayer;
        this.mediaListPlayer = mediaListPlayer;

        this.mediaParseSubject.attach(this);
    }

    @Override
    public void update(final Subject subject) {
        
        LOGGER.info("Media has been parsed");

        mediaPlayer.controls()
            .stop();
    }
    
}
