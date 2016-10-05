package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * the Tweetable interface to enable cross class interfacing of Tweets.
 * Created by watts1 on 9/13/16.
 */
public interface Tweetable {
    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage();

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate();
}
