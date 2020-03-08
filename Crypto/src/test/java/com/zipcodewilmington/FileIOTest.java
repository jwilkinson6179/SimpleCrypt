package com.zipcodewilmington;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static com.zipcodewilmington.FileIO.HOME;
import static org.junit.Assert.assertEquals;

public class FileIOTest
{
    @Test
    public void readFromFileTest() throws IOException {
        Object[] expected = {"Shall I compare thee to a summer’s day?\n",
                             "Thou art more lovely and more temperate:\n",
                             "Rough winds do shake the darling buds of May,\n",
                             "And summer’s lease hath all too short a date;\n",
                             "Sometime too hot the eye of heaven shines,\n",
                             "And often is his gold complexion dimm'd;\n",
                             "And every fair from fair sometime declines,\n",
                             "By chance or nature’s changing course untrimm'd;\n",
                             "But thy eternal summer shall not fade,\n",
                             "Nor lose possession of that fair thou ow’st;\n",
                             "Nor shall death brag thou wander’st in his shade,\n",
                             "When in eternal lines to time thou grow’st:\n",
                             "   So long as men can breathe or eyes can see,\n",
                             "   So long lives this, and this gives life to thee.\n" };
        Object[] actual = FileIO.readFromFile("/dev/SimpleCrypt/sonnet18.txt").toArray();

        assertEquals(expected, actual);
    }

    @Test
    public void writeToFileTest() throws IOException {
        ArrayList<String> content = new ArrayList<>();
        String file = "/dev/SimpleCrypt/test.txt";
        content.add("Hello");
        content.add("This is my file");
        Object[] expected = { "Hello\n", "This is my file\n" };
        FileIO.writeToFile(content, file);
        Object[] actual = FileIO.readFromFile(file).toArray();

        assertEquals(expected, actual);
    }
}
