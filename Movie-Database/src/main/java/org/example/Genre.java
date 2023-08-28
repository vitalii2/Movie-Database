package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Genre {
public Genre(){}
public static String getGenre(String name){
    Movie movie = new Movie();
   int [] genreId = Genre.getGernesNames(movie.getGenre(name));
    List<String> genres = new ArrayList<>();
    String wholeLine = "";
    try {
        URL url = new URL(ConfigurationManager.getInstance().getGenreApiUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Chrome");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();
        String line;
        while ((line = in.readLine()) != null){
           wholeLine += response.append(line);
        }
    } catch (MalformedURLException e) {
        System.out.println(e.getMessage());
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    for (int i = 0; i < genreId.length; i++) {
        Pattern p = Pattern.compile("\"id\":" + genreId[i] + "+,\"name\":\"(\\w+(\s\\w+)*)\"");
        Matcher m = p.matcher(wholeLine);
        while (m.find()){
           genres.add((m.group().split(":")[2].split("\"")[1]));
        }
    }
return genres.toString().replace("[","").replace("]","");
}
public static int[] getGernesNames(String s){
      int[] res = Arrays.stream(s.substring(1,s.length()-1).split(",")).mapToInt(Integer::parseInt).toArray();
//    int[] res = Arrays.stream(s.substring(1,s.length()-1).split(",")).mapToInt(Integer::parseInt).toArray();
    return res;
}
}
