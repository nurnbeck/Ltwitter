package ca.ualberta.cs.lonelytwitter;

/**
 * Created by watts1 on 9/13/16.
 */
public class NormalTweet extends Tweet implements Tweetable {
    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     */
/*
*this constructor takes an ordinary tweet and overrides the isImportant function with
*a new one.
*/
    public NormalTweet(String message){
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
