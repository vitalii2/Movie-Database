package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movie implements Comparable<Movie>{
    private String name;
    private int year;
    private String genre;
    private String overview;
    private Double vote_average;
    public Movie(){}

    public Movie(String name, int year, String genre, String overview, Double vote_average) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.overview = overview;
        this.vote_average = vote_average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre(String s) {
        String wholeLine = "";
        String genres = "";
        try {
            URL url = new URL(ConfigurationManager.getInstance().getFilmApiUrl() + s.replace(" ", "%20"));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Chrome");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = in.readLine()) != null){
                wholeLine += response.append(line);
            }
            Pattern p = Pattern.compile("\"genre_ids\":\\[\\d+(,\\d+)*\\]");
            Matcher m = p.matcher(wholeLine);
            while (m.find()){
                return m.group().split(":")[1];
            }

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", overview='" + overview + '\'' +
                ", vote_average=" + vote_average +
                '}';
    }

    @Override
    public int compareTo(Movie o) {
        if(this.vote_average > o.vote_average){
            return 1;
        } else if (this.vote_average < o.vote_average) {
            return 1;
        }else
            return 0;
    }
}
