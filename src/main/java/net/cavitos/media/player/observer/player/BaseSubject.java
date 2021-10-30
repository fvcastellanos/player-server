package net.cavitos.media.player.observer.player;

import java.util.ArrayList;
import java.util.List;

import net.cavitos.media.player.observer.Observer;
import net.cavitos.media.player.observer.Subject;

public abstract class BaseSubject implements Subject {

    private final List<Observer> observers;

    public BaseSubject() {

        observers = new ArrayList<>();
    }

    @Override
    public void attach(final Observer observer) {
        
        observers.add(observer);
    }

    @Override
    public void detach(final Observer observer) {

        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        observers.forEach(observer -> observer.update(this));
    }    
}
