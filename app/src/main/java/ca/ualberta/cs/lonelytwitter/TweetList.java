package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

/**
 * Maintains a list of tweets!
 */
public class TweetList {
    private List<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    public List<Tweet> getTweets() {
        Collections.sort(tweets);

        return tweets;
    }

    public void remove(Tweet tweet) {
        tweets.remove(tweet);
    }
    //returns size of list
    public int getCount(){return tweets.size();}
}
