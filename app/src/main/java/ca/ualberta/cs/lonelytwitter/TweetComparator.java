package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Nolan on 9/28/2016.
 * a failed experiment to create a comparator, replaced by the
 * CompareTo function
 */
import java.util.Arrays;
import java.util.Comparator;

/**
 * The type Tweet comparator.
 */
public abstract class TweetComparator implements Comparator{

    /**
     * Compare int.
     *
     * @param p the p
     * @param q the q
     * @return the int
     */
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

