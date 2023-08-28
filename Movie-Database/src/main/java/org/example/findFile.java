package org.example;

import java.io.File;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class findFile {
    public static String findUser(){
        String path = "D:\\java\\IJ SQL\\Movie-Database";
        File folder = new File(path);
        File[] file = folder.listFiles();
        for (File files :file) {
            Pattern p = Pattern.compile("([^\\\"]+).User.json");
            Matcher m = p.matcher(files.getName());
            if (m.find()){
                return m.group();
            }
        }
        return null;
    }
    public static String findMovie(){
        String path = "D:\\java\\IJ SQL\\Movie-Database";
        File foldedr = new File(path);
        File[] file = foldedr.listFiles();
        for (File files : file) {
            Pattern p = Pattern.compile("([^\\\"]+).Movie.json");
            Matcher m = p.matcher(files.getName());
            if (m.find()){
                return  m.group();
            }
        }
        return null;
    }
}
