package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class APIRequestTest {
    private final static String nameOfFilm = "Borat 1".replace(" ", "%20");
    @Test
    public void getMovieData() {
       String actual = APIRequest.getMovieData(nameOfFilm);
        String expected = "{\"page\":1,\"results\":[{\"adult\":false,\"backdrop_path\":\"/kt0Ku4cTQUZe4KyZiWC6HsWCbcS.jpg\",\"genre_ids\":[35],\"id\":496,\"original_language\":\"en\",\"original_title\":\"Borat: Cultural Learnings of America for Make Benefit Glorious Nation of Kazakhstan\",\"overview\":\"Kazakh journalist Borat Sagdiyev travels to America to make a documentary. As he zigzags across the nation, Borat meets real people in real situations with hysterical consequences. His backwards behavior generates strong reactions around him exposing prejudices and hypocrisies in American culture.\",\"popularity\":18.899,\"poster_path\":\"/kfkyALfD4G1mlBJI1lOt2QCra4i.jpg\",\"release_date\":\"2006-11-01\",\"title\":\"Borat: Cultural Learnings of America for Make Benefit Glorious Nation of Kazakhstan\",\"video\":false,\"vote_average\":6.753,\"vote_count\":4911}],\"total_pages\":1,\"total_results\":1}";
       assertEquals(expected.replaceAll("\\s",""),actual.replaceAll("\\s",""));
//       assertEquals(expected,actual);
//        if(!expected.equals(actual)){
//            for (int i = 0; i < Math.min(expected.length(),actual.length()); i++){
//                if(expected.charAt(i) != actual.charAt(i)){
//                    System.out.println("Difference index " + i + ":" + expected.charAt(i) + " vs. " + actual.charAt(i));
//                }else {
//                    System.out.println("Strings are identical.");
//                }
//            }
//        }
        System.out.println(actual.length());
        System.out.println(expected.length());
    }
}