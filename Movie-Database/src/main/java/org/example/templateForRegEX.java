package org.example;

import org.apache.commons.text.StringEscapeUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class templateForRegEX {
    public static String getNameRegEX(String s){
//        Pattern p = Pattern.compile("\"title\":\"([^\"]+)\"");
        String wholeLine = "";
        Pattern p = Pattern.compile("\"title\":\\\"([^\\\"]+)\\\"");
//        Pattern p2 = Pattern.compile("\"original\\wtitle\":\\\"([^\\\"]+)\\\"");
//        Matcher m2 = p2.matcher(s);
        Matcher m = p.matcher(s);
        if (m.find()){
            wholeLine = StringEscapeUtils.unescapeJava((m.group()).replaceAll("\"title\":",""));
           return wholeLine.replace("\"","");
        }
        return "";
    }
    public static Integer getYearRegEX(String s) {
        String wholeLine = "";
        Pattern pattern = Pattern.compile("\"release_date\":\"[0-9]{4}");
        Matcher m = pattern.matcher(s);
        if(m.find()){
            wholeLine = m.group().replaceAll("\"release_date\":\"","");
            return Integer.parseInt(wholeLine);
        }
        return null;
    }
    public static String getOverviewRegEX(String s){
        Pattern pattern = Pattern.compile("\\\"overview\\\":\\\"([^\\\"]+)\\\"");
        Matcher m = pattern.matcher(s);
        if(m.find()){
            return (m.group().replaceAll("\\\"overview\\\":","")).replace("\"","");
        }
        return "";
    }
    public static Double getVote_averageRegEX(String s){
        String wholeLine = "";
        Pattern pattern = Pattern.compile("\\\"vote_average\\\":[0-9]{1,}\\D[0-9]{1,}");
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            wholeLine = matcher.group().replaceAll("\\\"vote_average\\\":","");
            return Double.parseDouble(wholeLine);
        }
        return null;
    }
}
