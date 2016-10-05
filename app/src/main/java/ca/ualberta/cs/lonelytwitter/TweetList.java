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

    /**
     * Add tweet.
     *
     * @param tweet the tweet
     */
    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    /**
     * Has tweet boolean.
     *
     * @param tweet the tweet
     * @return the boolean
     */
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    /**
     * Gets tweet.
     *
     * @param i the
     * @return the tweet
     */
    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    /**
     * Gets tweets.
     *
     * @return the tweets
     */
    public List<Tweet> getTweets() {
        Collections.sort(tweets);

        return tweets;
    }

    /**
     * Remove.
     *
     * @param tweet the tweet
     */
    public void remove(Tweet tweet) {
        tweets.remove(tweet);
    }

    /**
     * Get count int.
     *
     * @return the int
     */
//returns size of list
    public int getCount(){return tweets.size();}
}
