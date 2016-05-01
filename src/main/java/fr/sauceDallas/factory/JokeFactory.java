package fr.sauceDallas.factory;

import fr.sauceDallas.domain.Joke;

/**
 * Created by gsigety on 30/04/16.
 */
public interface JokeFactory {

    Joke createJoke(String joke);

}

