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
                System.out.println(line);
                arrKeyVal = line.split(splitter);
                mapProfile.put(arrKeyVal[indKey], arrKeyVal[indVal]);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profile(mapProfile.get(keyName),
                           Integer.parseInt(mapProfile.get(keyAge).trim()),
                           mapProfile.get(keyEmail),
                           Long.parseLong(mapProfile.get(keyPhone).trim()));
    }
    
}
