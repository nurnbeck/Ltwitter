package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.List;

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
        list.addTweet(tweet);

        assertTrue(list.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList list = new TweetList();
        Tweet added = new NormalTweet("Testing...");
        Tweet notAdded = new NormalTweet("Testing...");

        assertFalse(list.hasTweet(added));
        list.addTweet(added);

        assertTrue(list.hasTweet(added));
        assertFalse(list.hasTweet(notAdded));
    }

    /**
     * Tests getting tweet by index.
     */
    public void testGetTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Hello");
        list.addTweet(tweet);

        Tweet returnedTweet = list.getTweet(0);
        assertEquals(tweet.getMessage(), returnedTweet.getMessage());
        assertEquals(tweet.getDate(), returnedTweet.getDate());
    }

    public void testDeleteTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        list.addTweet(tweet);
        list.remove(tweet);
        assertFalse(list.hasTweet(tweet));
    }
    //return size of list
    public void testGetCount(){
        TweetList list = new TweetList();
        TweetList mylist = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        list.addTweet(tweet);
        mylist.addTweet(tweet);

        list.getCount();
        assertFalse(list.getCount() == mylist.getCount());
    }

    public void testGetTweets(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Hello");
        list.addTweet(tweet);
        Tweet tweet2 = new NormalTweet("Hello");
        list.addTweet(tweet2);
        Tweet tweet3 = new NormalTweet("Hello");
        list.addTweet(tweet3);

        list.getTweets();
        assertTrue(list.getTweet(0)==tweet);

    }
}
