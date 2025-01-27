package com.epam.mjc.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

        public Profile getDataFromFile(File file) {
        String splitter = ":";
        String keyName = "Name";
        String keyAge = "Age";
        String keyEmail = "Email";
        String keyPhone = "Phone";
        Map<String, String> mapProfile = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file.getAbsolutePath()))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String [] arrKeyVal;
                final int indKey = 0;
                final int indVal = 1;
                arrKeyVal = line.split(splitter);
                mapProfile.put(arrKeyVal[indKey].trim(), arrKeyVal[indVal].trim());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profile(mapProfile.get(keyName),
                Integer.parseInt(mapProfile.get(keyAge)),
                mapProfile.get(keyEmail),
                Long.parseLong(mapProfile.get(keyPhone)));
    }
    
}
