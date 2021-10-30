package net.cavitos.media.player.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.cavitos.media.player.observer.Subject;
import uk.co.caprica.vlcj.media.Media;
import uk.co.caprica.vlcj.media.MediaEventListener;
import uk.co.caprica.vlcj.media.MediaParsedStatus;
import uk.co.caprica.vlcj.media.MediaRef;
import uk.co.caprica.vlcj.media.Meta;
import uk.co.caprica.vlcj.media.Picture;
import uk.co.caprica.vlcj.player.base.State;

@Component
public class DefaultMediaEventListener implements MediaEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMediaEventListener.class);

    @Autowired
    private Subject mediaParseSubject;

    @Override
    public void mediaDurationChanged(Media arg0, long arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mediaFreed(Media arg0, MediaRef arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mediaMetaChanged(Media arg0, Meta arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mediaParsedChanged(Media media, MediaParsedStatus mediaParsedStatus) {

        LOGGER.info("Media parsed with status: {}", mediaParsedStatus.name());

        if (mediaParsedStatus == MediaParsedStatus.DONE) {

            mediaParseSubject.notifyObservers();
        }
        
    }

    @Override
    public void mediaStateChanged(Media arg0, State arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mediaSubItemAdded(Media arg0, MediaRef arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mediaSubItemTreeAdded(Media arg0, MediaRef arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mediaThumbnailGenerated(Media arg0, Picture arg1) {
        // TODO Auto-generated method stub
        
    }
    
}
