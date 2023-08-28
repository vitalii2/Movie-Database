package org.example;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class TestMyClass {
    private static final Logger logger = Logger.getLogger(TestMyClass.class.getName());
  @Test
    public void TestMyMethod(){
        logger.info("Method has been called");
        String actual = APIRequest.getMovieData("The terminator 1".replace(" ", "%20"));
        String expected = "{\"page\":1,\"results\":[{\"adult\":false,\"backdrop_path\":\"/dH6m8iWJEPIFoyQaZiuo9Ih7kpA.jpg\",\"genre_ids\":[28,53,878],\"id\":218,\"original_language\":\"en\",\"original_title\":\"The Terminator\",\"overview\":\"In the post-apocalyptic future, reigning tyrannical supercomputers teleport a cyborg assassin known as the \\\"Terminator\\\" back to 1984 to kill Sarah Connor, whose unborn son is destined to lead insurgents against 21st century mechanical hegemony. Meanwhile, the human-resistance movement dispatches a lone warrior to safeguard Sarah. Can he stop the virtually indestructible killing machine?\",\"popularity\":62.44,\"poster_path\":\"/hzXSE66v6KthZ8nPoLZmsi2G05j.jpg\",\"release_date\":\"1984-10-26\",\"title\":\"The Terminator\",\"video\":false,\"vote_average\":7.644,\"vote_count\":11775}],\"total_pages\":1,\"total_results\":1}";
        assertEquals(expected,actual);
    }
}
