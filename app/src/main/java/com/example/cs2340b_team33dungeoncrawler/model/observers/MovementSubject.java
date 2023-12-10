package com.example.cs2340b_team33dungeoncrawler.model.observers;


import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MovementSubject {
    private List<MovementObserver> observers = new ArrayList<>();

    public void addObserver(MovementObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(MovementObserver observer) {
        observers.remove(observer);
    }

    public MovementSubject getObserver() {
        return this;
    }


    /*
    This is the main observer framework.
    When the button press calls notifyObservers(), this method is called.

     */
    public void notifyObservers(ImageView sprite) {
        for (MovementObserver observer : observers) {
            //Go to MoveLeftObserver.java to see what happens next
            observer.handleMovement(sprite);
        }
    }
}
