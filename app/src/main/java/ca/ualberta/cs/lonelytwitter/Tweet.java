package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by watts1 on 9/13/16.
 */
public abstract class Tweet implements Comparable<Tweet> {
    private String message;
    private Date date;

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }


    public abstract Boolean isImportant();




    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            //Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        return  date.toString() + " | " + message;
    }


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
