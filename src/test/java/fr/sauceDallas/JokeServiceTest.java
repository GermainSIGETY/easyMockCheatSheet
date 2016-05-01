package fr.sauceDallas;

import fr.sauceDallas.dao.JokeDao;
import fr.sauceDallas.domain.Joke;
import fr.sauceDallas.factory.JokeFactory;
import fr.sauceDallas.service.JokeService;
import fr.sauceDallas.service.implementation.StandardJokeService;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by gsigety on 30/04/16.
 */
@RunWith(EasyMockRunner.class)
public class JokeServiceTest {

    @TestSubject
    JokeService jokeService = new StandardJokeService();

    @Mock
    JokeFactory jokeFactory;

    @Mock
    JokeDao jokeDao;

    @Test
    public void testStorage() {

        String jokeToStore = "What do you call a cow without legs?\n Ground beef.";

        //record Phase
        EasyMock.expect(jokeFactory.createJoke(EasyMock.anyString())).andReturn(new Joke(jokeToStore));

        jokeDao.persistJoke(EasyMock.anyObject(Joke.class));
        EasyMock.expectLastCall().once();

        EasyMock.replay(jokeFactory, jokeDao);

        jokeService.storeAJoke(jokeToStore);

        EasyMock.verify(jokeFactory,jokeDao);
    }

    @Test
    public void testStorageWithCapture() {

        String jokeToStore = "What do you call a cow without legs?\n Ground beef.";

        Capture<Joke> capturedJoke =  EasyMock.newCapture();

        //record Phase
        EasyMock.expect(jokeFactory.createJoke(EasyMock.anyString())).andReturn(
                new Joke(jokeToStore));

        jokeDao.persistJoke(EasyMock.capture(capturedJoke));
        EasyMock.expectLastCall().once();

        EasyMock.replay(jokeFactory, jokeDao);

        jokeService.storeAJoke(jokeToStore);

        EasyMock.verify(jokeFactory,jokeDao);

        Assert.assertEquals(jokeToStore, capturedJoke.getValue().getJokeContent());

    }
}
