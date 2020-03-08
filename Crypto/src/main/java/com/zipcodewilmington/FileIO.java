package com.zipcodewilmington;

import java.io.*;
import java.util.ArrayList;

public class FileIO
{
    public static final String HOME = System.getProperty("user.home");

    public static String readFromFile(String fileName) throws IOException
    {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        ArrayList<String> readContent = new ArrayList<>();

        while ((line = br.readLine()) != null)
        {
            readContent.add(line + "\n");
        }
        br.close();

        StringBuilder output = new StringBuilder();
        for(String element : readContent)
        {
            output.append(element);
        }

        return output.toString();
    }

    public static void writeToFile(String content, String fileName) throws IOException
    {
        File file = new File(fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        String[] contentSeperatedByLine = content.split("\n");
        for(String line : contentSeperatedByLine) {
            bw.write(line);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}