package com.zipcodewilmington;

import java.io.*;
import java.util.ArrayList;

public class FileIO
{
    public static final String HOME = System.getProperty("user.home");

    public static ArrayList<String> readFromFile(String fileName) throws IOException
    {
        File file = new File(HOME + fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        ArrayList<String> output = new ArrayList<>();

        while ((line = br.readLine()) != null)
        {
            output.add(line + "\n");
        }
        br.close();

        return output;
    }

    public static void writeToFile(ArrayList<String> content, String fileName) throws IOException
    {
        File file = new File(HOME + fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        for(String line : content) {
            bw.write(line);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}