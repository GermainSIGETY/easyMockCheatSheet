package fr.sauceDallas.service.implementation;

import fr.sauceDallas.dao.JokeDao;
import fr.sauceDallas.dao.EventDao;
import fr.sauceDallas.domain.Joke;
import fr.sauceDallas.factory.JokeFactory;
import fr.sauceDallas.service.JokeService;

import javax.inject.Inject;

/**
 * Created by gsigety on 30/04/16.
 */
public class StandardJokeService implements JokeService {

    @Inject
    private JokeDao jokeDao;

    @Inject
    EventDao eventDao;

    @Inject
    JokeFactory jokeFactory;

    public void storeAJoke(String joke) {

        Joke jokeToStore = jokeFactory.createJoke(joke);
        jokeDao.persistJoke(jokeToStore);

    }

    public void storeAJokeWithEvent(String joke) {

        Joke jokeToStore = jokeFactory.createJoke(joke);

        eventDao.storeEvent("before persist");

        jokeDao.persistJoke(jokeToStore);

        eventDao.storeEvent("after persist");
    }
}
