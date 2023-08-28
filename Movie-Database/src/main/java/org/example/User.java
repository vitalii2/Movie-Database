package org.example;

import java.util.List;

public class User {
    private String name;
    private String films;
    private Double grade;
    public User(){}

    public User(String name, String films,  Double grade) {
        this.name = name;
        this.films = films;
        this.grade = grade;
    }
//    public User(String name,String films, Double grade){
//
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilms() {
        return films;
    }

    public void setFilms(String films) {
        this.films = films;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade (Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", films=" + films +
                ", grade=" + grade +
                '}';
    }
}
