package org.example;

import java.util.*;

public class Main {
    //    private final static String nameOfFilm = "Scary movie 3".replace(" ","%20");
//    private final static String nameOfFilm = "Borat 1".replace(" ","%20");
//private final static String nameOfFilm = "Titanic".replace(" ","%20");
    private final static String nameOfFilm = "The terminator 1".replace(" ", "%20");

    private final static String nameOfFilmForUserDB = nameOfFilm.replace("%20", " ");

    public static void main(String[] args) {
        Movie movie = new Movie();


        movie.setName(templateForRegEX.getNameRegEX(APIRequest.getMovieData(nameOfFilm)));
        movie.setYear(templateForRegEX.getYearRegEX(APIRequest.getMovieData(nameOfFilm)));
        movie.setGenre(Genre.getGenre(nameOfFilm));
        movie.setOverview(templateForRegEX.getOverviewRegEX(APIRequest.getMovieData(nameOfFilm)));
        movie.setVote_average(templateForRegEX.getVote_averageRegEX(APIRequest.getMovieData(nameOfFilm)));
//        SQLUtils.seveToDBMovie(movie);
//        System.out.println(movie);
//        DBforUser.createUserdb();


//        User user = new User();
//        user.setName("Stas");
//        user.setFilms(nameOfFilmForUserDB);
//        user.setGrade(6.55);
//
        User user = new User();
        user.setName("Marco");
        user.setFilms(nameOfFilmForUserDB);
        user.setGrade(9.35);
//        DBforUser.saveUser(user);
//        List<User> userList = DBforUser.getUserData("SELECT * FROM user");
//        System.out.println(userList);
//        System.out.println(DBforUser.getDataUserName(user.getName()));
//        actionToJSON.toJSONfile(user);
//        actionToJSON.toJSONfile(movie);
//        System.out.println(findFile.findUser());
//        System.out.println(findFile.findMovie());
        actionToJSON.fromJSONtoClass(findFile.findMovie());
    }
}