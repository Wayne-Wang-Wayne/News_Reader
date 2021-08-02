package com.example.myapplication.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

    public static List<String> findAllMatches(String matchedString, String regexPattern){

        List<String> allMatches = new ArrayList<>();
        Matcher m = Pattern.compile(regexPattern)
                .matcher(matchedString);
        while (m.find()) {
            allMatches.add(m.group());
        }

        return allMatches;
    }
}
