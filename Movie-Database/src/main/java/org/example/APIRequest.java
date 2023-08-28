package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APIRequest {
    public APIRequest(){}
    public static String getMovieData(String s){
        String wholeLine = "";
        URL url = null;
        try {
            url = new URL(ConfigurationManager.getInstance().getFilmApiUrl() + s);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Usre-Agent", "Chrome");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer inputLine = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null){
               wholeLine += inputLine.append(line);
                }
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wholeLine;
    }
}
