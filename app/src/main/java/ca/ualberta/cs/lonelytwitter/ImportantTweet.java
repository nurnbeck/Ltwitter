package ca.ualberta.cs.lonelytwitter;

/**
 * This is the important tweet class from lab 2.
 * Created by watts1 on 9/13/16.
 *
 * @see ImportantTweet
 */
public class ImportantTweet extends Tweet {

    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     */
    public ImportantTweet(String message){
        super(message);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

}
