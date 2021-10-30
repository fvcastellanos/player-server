package net.cavitos.media.player.event;

import org.springframework.stereotype.Component;

import uk.co.caprica.vlcj.media.MediaRef;
import uk.co.caprica.vlcj.media.TrackType;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventListener;

@Component
public class DefaultMediaPlayerEventListener implements MediaPlayerEventListener {

    @Override
    public void audioDeviceChanged(MediaPlayer arg0, String arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void backward(MediaPlayer arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void buffering(MediaPlayer arg0, float arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void chapterChanged(MediaPlayer arg0, int arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void corked(MediaPlayer arg0, boolean arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void elementaryStreamAdded(MediaPlayer arg0, TrackType arg1, int arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void elementaryStreamDeleted(MediaPlayer arg0, TrackType arg1, int arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void elementaryStreamSelected(MediaPlayer arg0, TrackType arg1, int arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void error(MediaPlayer arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void finished(MediaPlayer arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void forward(MediaPlayer arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void lengthChanged(MediaPlayer arg0, long arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mediaChanged(MediaPlayer arg0, MediaRef arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mediaPlayerReady(MediaPlayer arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void muted(MediaPlayer arg0, boolean arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void opening(MediaPlayer arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pausableChanged(MediaPlayer arg0, int arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void paused(MediaPlayer arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void playing(MediaPlayer arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void positionChanged(MediaPlayer arg0, float arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void scrambledChanged(MediaPlayer arg0, int arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void seekableChanged(MediaPlayer arg0, int arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void snapshotTaken(MediaPlayer arg0, String arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void stopped(MediaPlayer arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void timeChanged(MediaPlayer arg0, long arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void titleChanged(MediaPlayer arg0, int arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void videoOutput(MediaPlayer arg0, int arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void volumeChanged(MediaPlayer arg0, float arg1) {
        // TODO Auto-generated method stub
        
    }
    
}
