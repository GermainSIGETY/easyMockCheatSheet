package fr.sauceDallas.domain;

/**
 * Created by gsigety on 30/04/16.
 */
public class Joke {

    String jokeContent;

    public Joke(String joke) {
        jokeContent = joke;
    }

    public String getJokeContent() {
        return jokeContent;
    }
}
