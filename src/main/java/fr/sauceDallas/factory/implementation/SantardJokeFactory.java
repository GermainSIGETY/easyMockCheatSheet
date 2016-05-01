package fr.sauceDallas.factory.implementation;

import fr.sauceDallas.domain.Joke;
import fr.sauceDallas.factory.JokeFactory;

/**
 * Created by gsigety on 30/04/16.
 */
public class SantardJokeFactory implements JokeFactory{
    public Joke createJoke(String joke) {
        return new Joke(joke);
    }
}
