package com.zipcodewilmington;

import java.io.*;

public class FileIO
{
    public static final String HOME = System.getProperty("user.home");

    public static String readFromFile(String fileName) throws IOException
    {
        File file = new File(HOME + fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder fileAsString = new StringBuilder();

        while ((line = br.readLine()) != null)
        {
            fileAsString.append(line);
        }

        return fileAsString.toString();
    }
}