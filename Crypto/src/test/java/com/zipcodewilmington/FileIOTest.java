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
        String expected =   "Shall I compare thee to a summer’s day?\n" +
                            "Thou art more lovely and more temperate:\n" +
                            "Rough winds do shake the darling buds of May,\n" +
                            "And summer’s lease hath all too short a date;\n" +
                            "Sometime too hot the eye of heaven shines,\n" +
                            "And often is his gold complexion dimm'd;\n" +
                            "And every fair from fair sometime declines,\n" +
                            "By chance or nature’s changing course untrimm'd;\n" +
                            "But thy eternal summer shall not fade,\n" +
                            "Nor lose possession of that fair thou ow’st;\n" +
                            "Nor shall death brag thou wander’st in his shade,\n" +
                            "When in eternal lines to time thou grow’st:\n" +
                            "   So long as men can breathe or eyes can see,\n" +
                            "   So long lives this, and this gives life to thee.\n";
        String actual = FileIO.readFromFile(HOME + "/dev/SimpleCrypt/sonnet18.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void writeToFileTest() throws IOException {
        String file = HOME + "/dev/SimpleCrypt/test.txt";
        String expected = "Hello\nThis is my file\n";
        FileIO.writeToFile(expected, file);
        String actual = FileIO.readFromFile(file);

        assertEquals(expected, actual);
    }
}
