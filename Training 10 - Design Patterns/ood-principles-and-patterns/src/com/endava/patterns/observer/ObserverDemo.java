package com.endava.patterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by rburlacioiu on 7/22/2016.
 */
public class ObserverDemo {

    public static void main(String[] args) {

        TwitterStream messageStream = new TwitterStream();

        Client client1 = new Client("Andra");
        Client client2 = new Client("Razvan");

        messageStream.addObserver(client1);
        messageStream.addObserver(client2);

        messageStream.deleteObserver(client2);

        messageStream.someoneTweeted();
    }
}

//concrete subject
class TwitterStream extends Observable {

    public void someoneTweeted() {
        setChanged();
        notifyObservers();
    }
}

//concrete observer
class Client implements Observer {

    public String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update " + name + "'s stream, someone tweeted something.");
    }
}