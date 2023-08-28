package org.example;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DBforUser {
    private static String INSERT_USER = "INSERT INTO user(name,films,grade) VALUES(?,?,?)";
    public static void createUserdb(){

        try(Connection connection = DBUtils.getConnectionForUser();
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE DATABASE IF NOT EXISTS users;");) {
//            CREATE TABLE IF NOT EXISTS User(\n"
//                    + "name TEXT NOT NULL, films TEXT NOT NULL, grades TEXT NOT NULL);")
            preparedStatement.execute("USE users;");
            preparedStatement.execute("CREATE TABLE IF NOT EXISTS User(name VARCHAR(50), films VARCHAR(500), grade VARCHAR(500));");
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static List<User> saveUser(User user){
        List<User> users = new ArrayList<>();
        try (Connection connection = DBUtils.getConnectionForUser();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);){
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2, user.getFilms().toString());
        preparedStatement.setDouble(3,user.getGrade());
        preparedStatement.executeUpdate();
        PreparedStatement allUsers = connection.prepareStatement("SELECT * FROM user");
        ResultSet rs = allUsers.executeQuery();
        while (rs.next()){
            String name = rs.getString("name");
            String films = rs.getString("films");
            Double grade = rs.getDouble("grade");
            users.add(new User(name,films,grade));
        }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return users;
    }
    public static List<User> getUserData(String query){
        List<User> users = new ArrayList<>();
        try(Connection connection = DBUtils.getConnectionForUser();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String films = rs.getString("films");
                Double grade = rs.getDouble("grade");
                users.add(new User(name,films,grade));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return users;
    }
    public static List<User> getDataUserName(String userName){
        List <User> users = new ArrayList<>();
        try (Connection connection = DBUtils.getConnectionForUser();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE name = ?;");){
        preparedStatement.setString(1,userName);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            String name = rs.getString("name");
            String films = rs.getString("films");
            Double grade = rs.getDouble("grade");
            users.add(new User(name,films,grade));
        }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return users;
    }
}
