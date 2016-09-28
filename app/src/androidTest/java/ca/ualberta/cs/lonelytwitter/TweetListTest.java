package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Tests our TweetList class.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Testing...");
        list.add(tweet);

        assertTrue(list.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList list = new TweetList();
        Tweet added = new NormalTweet("Testing...");
        Tweet notAdded = new NormalTweet("Testing...");

        assertFalse(list.hasTweet(added));
        list.add(added);

        assertTrue(list.hasTweet(added));
        assertFalse(list.hasTweet(notAdded));
    }

    /**
     * Tests getting tweet by index.
     */
    public void testGetTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Hello");
        list.add(tweet);

        Tweet returnedTweet = list.getTweet(0);
        assertEquals(tweet.getMessage(), returnedTweet.getMessage());
        assertEquals(tweet.getDate(), returnedTweet.getDate());
    }

    public void testDeleteTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        list.add(tweet);
        list.remove(tweet);
        assertFalse(list.hasTweet(tweet));
    }
}
