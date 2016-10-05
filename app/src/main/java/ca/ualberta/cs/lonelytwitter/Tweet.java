package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * this is the tweet model class.
 *
 * @see Tweet Created by watts1 on 9/13/16.
 */
public abstract class Tweet implements Comparable<Tweet> {
    private String message;
    private Date date;

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     * @param date    the date
     */
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }


    /**
     * Is important boolean.
     *
     * @return the boolean
     */
    public abstract Boolean isImportant();


    /**
     * Sets message.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            //Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        return  date.toString() + " | " + message;
    }

/*
* this function is written to compare tweets to one
* another and enable use of collections.sort
 */
    public int compareTo(Tweet compareTweet) {

        Date compareDate = ((Tweet) compareTweet).getDate();
        //ascending order
        if (this.getDate().after(compareDate))
        {
            return 1;
        }

        if (this.getDate().equals(compareDate))
        {
            return 0;
        }
        return 1;
        //descending order
        //return compareQuantity - this.quantity;

    }
    /*
    public Tweet compare(Tweet p, Tweet q) {
        // descending order (ascending order would be:
        // o1.getGrade()-o2.getGrade())
        if (p.getDate().after(q.getDate()))
        {
            return q;
        }
        else{return p;}
    }
    */
}
