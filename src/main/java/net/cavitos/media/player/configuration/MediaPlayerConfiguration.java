package net.cavitos.media.player.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.media.MediaEventListener;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventListener;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayerEventListener;

@Configuration
public class MediaPlayerConfiguration {
    
    @Bean
    public MediaPlayerFactory mediaPlayerFactory() {

        return new MediaPlayerFactory();
    }

    @Bean
    public MediaPlayer mediaPlayer(final MediaPlayerFactory mediaPlayerFactory,
                                   final MediaPlayerEventListener mediaPlayerEventListener,
                                   final MediaEventListener mediaEventListener) {

        final var mediaPlayer = mediaPlayerFactory.mediaPlayers()
            .newMediaPlayer();

        mediaPlayer.events()
            .addMediaPlayerEventListener(mediaPlayerEventListener);

        mediaPlayer.events()
            .addMediaEventListener(mediaEventListener);

        return mediaPlayer;                        
    }

    @Bean
    public MediaListPlayer mediaListPlayer(final MediaPlayerFactory mediaPlayerFactory, 
                                           final MediaListPlayerEventListener mediaListPlayerEventListener,
                                           final MediaPlayer mediaPlayer) {                                    

        final var mediaListPlayer = mediaPlayerFactory.mediaPlayers()
            .newMediaListPlayer();

        mediaListPlayer.events()
            .addMediaListPlayerEventListener(mediaListPlayerEventListener);

        mediaListPlayer.mediaPlayer() // Media Player API
            .setMediaPlayer(mediaPlayer);

        return mediaListPlayer;
    }
}
