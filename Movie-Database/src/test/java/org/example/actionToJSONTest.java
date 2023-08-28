package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class actionToJSONTest {

    @Test
    public void toJSONfile() {
        String expected = "{\"name\":\"Frederico Fellini\",\"films\":\"Borat\",\"grade\":7.45}\n".replaceAll("\\s","");
        User user = new User();
        user.setName("Frederico Fellini");
        user.setFilms("Borat");
        user.setGrade(7.45);
        actionToJSON.toJSONfile(user);
        File file = new File("dataorg.example.User.json");
        String wholeLine = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null){
                wholeLine += line;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expected,wholeLine.replaceAll("\\s",""));
    }

    @Test
    public void fromJSONtoClass() {
        File file = new File("dataorg.example.User.json");
        String wholeLine = "";
        String expected = "{\"name\":\"Frederico Fellini\",\"films\":\"Borat\",\"grade\":7.45}";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null){
                wholeLine += line;
            }
            ObjectMapper mapper = new ObjectMapper();
            Object o = mapper.readValue(wholeLine,Object.class);
            System.out.println(o.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String acttual = wholeLine;
        assertEquals(expected,acttual);
    }
}