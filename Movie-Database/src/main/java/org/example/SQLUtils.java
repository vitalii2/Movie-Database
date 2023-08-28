package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLUtils {
    private static String INSERT_MOVIE = "INSERT  INTO movie(name,year,genre,overview,vote_average) VALUES(?,?,?,?,?)";
    public static List<Movie> seveToDBMovie(Movie movie){
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOVIE);){
            preparedStatement.setString(1,movie.getName());
            preparedStatement.setInt(2,movie.getYear());
            preparedStatement.setString(3,movie.getGenre());
            preparedStatement.setString(4,movie.getOverview());
            preparedStatement.setDouble(5,movie.getVote_average());
            preparedStatement.executeUpdate();
            PreparedStatement allFilms = connection.prepareStatement("SELECT * FROM movie");
            ResultSet rs = allFilms.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                int year = rs.getInt("year");
                String genre = rs.getString("genre");
                String overview = rs.getString("overview");
                Double vote_average = rs.getDouble("vote_average");
                movies.add(new Movie(name,year,genre,overview,vote_average));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return movies;
    }
}
