package net.cavitos.media.player.observer;

public interface Subject {   

    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
