package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Nolan on 9/28/2016.
 */
import java.util.Arrays;
import java.util.Comparator;
public abstract class TweetComparator implements Comparator{

    public int compare(Tweet p, Tweet q) {
        // descending order (ascending order would be:
        // p.getDate().after(q.getGrade())
        if (p.getDate().after(q.getDate()))
        {
            return 1;
        }

        if (p.getDate().equals(q.getDate()))
        {
            return 0;
        }
        return 1;
    }

    }

