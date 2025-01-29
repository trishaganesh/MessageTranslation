package com.trishawrites;

/**
 * This class defines an Decryption object.
 *
 * @author Trisha Ganesh
 * @version 07/6/2021
 */

public class Decryption
{
    //Constructor for objects of class Decryption
    public Decryption()
    {
        // Constructor for objects of Decryption class
    }


     //A static method used to generate the decryption (Used for the decryption relating to alphabet.)
    public static String decryptABCLetters(int shift, char[] base)
    {
        String decryptedMessage = "";
        for(char decrypt : base)
        {
            decryptedMessage += decrypt;
        }

        return decryptedMessage.substring(base.length - shift) + decryptedMessage.substring(0,base.length - shift);
    }
    //A static method used to generate the decryption (Used for the decryption relating to message .)
    public static String decryptingMessage(int shift, String[] base)
    {
        String[] abcValues = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L",
                "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String[] ciphered = new String[base.length];
        String cipheredMessage = "";
        int val = abcValues.length - 1;

        for(int index = 0; index < ciphered.length; index++)
        {
            for (int k = 0; k < abcValues.length; k++)
            {
                if(abcValues[k].equalsIgnoreCase(base[index]))
                {
                    if(k - shift >= 0)
                    {
                        ciphered[index] = abcValues[k - shift];
                    }
                    else
                    {
                        ciphered[index] = abcValues[(val - k) + (shift - 1)];
                    }
                }
                else if(base[index].equals(" "))
                {
                    ciphered[index] = " ";
                }
            }
        }

        for(String cipher : ciphered)
        {
            cipheredMessage += cipher;
        }
        return cipheredMessage;
    }
}
