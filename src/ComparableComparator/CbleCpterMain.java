package ComparableComparator;

import java.util.ArrayList;
import java.util.Collections;

public class CbleCpterMain {

    public static void main(String[] args) {

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Force Awakens", 8.3, 2015));
        movieList.add(new Movie("Star Wars", 8.7, 1977));
        movieList.add(new Movie("Empire Strikes Back", 8.8, 1980));
        movieList.add(new Movie("Return of the Jedi", 8.4, 1983));

        //Comparable
        Collections.sort(movieList);
        System.out.println("Movies after sorting : ");
        for (Movie movie: movieList)
        {
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }

        //Comparator
        Collections.sort(movieList,new RatingCompare());

    }
}
