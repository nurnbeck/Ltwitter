package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Maintains a list of tweets!
 */
public class TweetList {
    private List<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    public void remove(Tweet tweet) {
        tweets.remove(tweet);
    }
}
