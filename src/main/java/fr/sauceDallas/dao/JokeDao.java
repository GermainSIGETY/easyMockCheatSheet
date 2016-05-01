package fr.sauceDallas.dao;

import fr.sauceDallas.domain.Joke;

/**
 * Created by gsigety on 30/04/16.
 */
public interface JokeDao {

    void persistJoke(Joke joke);
}
