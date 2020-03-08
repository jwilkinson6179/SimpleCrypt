package com.zipcodewilmington;

import java.io.IOException;

import static com.zipcodewilmington.FileIO.HOME;

public class MainApplication {

    public static void main(String[] args) throws IOException
    {
        JamesWCipher cipher = new JamesWCipher();
        System.out.println("Our input passage is: \n");
        String inputFromFile = FileIO.readFromFile(HOME + "/dev/SimpleCrypt/sonnet18.txt");
        System.out.println(inputFromFile);
        String encryptedString = cipher.encrypt(inputFromFile);
        System.out.println("Our information is now encrypted.\n\n\n");
        FileIO.writeToFile(encryptedString, HOME + "/dev/SimpleCrypt/sonnet18.enc");
        System.out.println("The information has been written to file as: ");
        System.out.println(FileIO.readFromFile(HOME + "/dev/SimpleCrypt/sonnet18.enc"));
        System.out.println("We decrypt that document as: \n");
        System.out.println(cipher.decrypt(FileIO.readFromFile(HOME + "/dev/SimpleCrypt/sonnet18.enc")));
    }
}
