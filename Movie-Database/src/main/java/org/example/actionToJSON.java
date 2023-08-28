package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class actionToJSON {
    public static void toJSONfile(Object T){
        ObjectMapper om = new ObjectMapper();

        try {
            File file = new File("data"+ T.getClass().getName() +".json");
            String res = om.writeValueAsString(T);
            PrintWriter pw = new PrintWriter(file);
            pw.println(res);
            pw.close();
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void fromJSONtoClass(String s){
        File file = new File(s);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String wholeLine = "";
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
    }
}
