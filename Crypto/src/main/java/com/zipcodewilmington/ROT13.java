package com.zipcodewilmington;

import static java.lang.Character.*;

public class ROT13
{
    Integer shift;
    Boolean isEncrypted;

    public ROT13(Character cs, Character cf)
    {
        shift = (int)cf - (int)cs;
        isEncrypted = false;
    }

    public ROT13()
    {
        this('a', 'n');
    }

    public String crypt(String text) throws UnsupportedOperationException
    {
        if(isEncrypted)
        {
            isEncrypted = false;
            return decrypt(text);

        }
        else
        {
            isEncrypted = true;
            return encrypt(text);
        }
    }

    public String encrypt(String text)
    {
        char[] textAsChars = text.toCharArray();
        StringBuilder encrypted = new StringBuilder();

        for(char letter : textAsChars)
        {
            // For upper-case
            if(64 < letter && letter < 91)
            {
                int charUnicodeValue = (int) letter;
                charUnicodeValue -= 64;
                charUnicodeValue = (charUnicodeValue + shift) % 26;
                charUnicodeValue += 64;
                encrypted.append((char)charUnicodeValue);
            }
            // For lower-case
            else if(96 < letter && letter < 123)
            {
                int charUnicodeValue = (int) letter;
                charUnicodeValue -= 96;
                charUnicodeValue = (charUnicodeValue + shift) % 26;
                charUnicodeValue += 96;
                encrypted.append((char)charUnicodeValue);
            }
            else
            {
                encrypted.append(letter);
            }
        }

        return encrypted.toString();
    }

    public String decrypt(String text)
    {

        char[] textAsChars = text.toCharArray();
        StringBuilder encrypted = new StringBuilder();

        for(char letter : textAsChars)
        {
            // For upper-case
            if(64 < letter && letter < 91)
            {
                int charUnicodeValue = (int) letter;
                charUnicodeValue -= 64;
                charUnicodeValue = (charUnicodeValue - shift + 26) % 26;
                charUnicodeValue += 64;
                encrypted.append((char)charUnicodeValue);
            }
            // For lower-case
            else if(96 < letter && letter < 123)
            {
                int charUnicodeValue = (int) letter;
                charUnicodeValue -= 96;
                charUnicodeValue = (charUnicodeValue - shift + 26) % 26;
                charUnicodeValue += 96;
                encrypted.append((char)charUnicodeValue);
            }
            else
            {
                encrypted.append(letter);
            }
        }

        return encrypted.toString();
    }

    public String rotate(String s, Character c)
    {
        char[] phrase = s.toCharArray();
        Integer idx;

        for(idx = 0; idx < phrase.length; idx++)
        {
            if(phrase[idx] == c)
            {
                break;
            }
        }

        StringBuilder rotatedPhrase = new StringBuilder();
        rotatedPhrase.append(s.substring(idx));
        rotatedPhrase.append(s.substring(0, idx));

        return rotatedPhrase.toString();
    }
}
