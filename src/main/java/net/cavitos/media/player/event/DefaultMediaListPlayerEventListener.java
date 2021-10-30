package net.cavitos.media.player.event;

import org.springframework.stereotype.Component;

import uk.co.caprica.vlcj.media.MediaRef;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayerEventListener;

@Component
public class DefaultMediaListPlayerEventListener implements MediaListPlayerEventListener {

    @Override
    public void mediaListPlayerFinished(MediaListPlayer arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void nextItem(MediaListPlayer arg0, MediaRef arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void stopped(MediaListPlayer arg0) {
        // TODO Auto-generated method stub
        
    }
}
