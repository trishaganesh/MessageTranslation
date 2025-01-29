package com.trishawrites;
/**
 * This class defines an Encryption object.
 *
 * @author Trisha Ganesh
 * @version 07/6/2021
 */

    public class Encryption
    {

        public Encryption()
        {
            // Constructor for objects of Encryption class
        }


         //A static method to generate the cipher (used for the alphabet cipher)
        public static char[] cipherABCLetters(int shift, char[] base)
        {
            String cipheredMessage = "";
            char[] ciphered = new char[base.length];
            int j = 0;

            for(int i = shift; i < base.length; i++)
            {
                ciphered[j] = base[i];
                j++;
            }

            int i = 0;
            while(ciphered[base.length - 1] == (char) 0)
            {
                ciphered[j] = base[i];
                j++;
                i++;
            }

            return ciphered;
        }

        //A static method to generate the cipher (used for the cipher relating to messaging)
        public static String cipherMessage(int shift, String[] base)
        {
            String[] abcValues = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L",
                    "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
            String cipheredMessage = "";
            String[] ciphered = new String[base.length];
            int value = 1;

            for(int index = 0; index < ciphered.length; index++)
            {
                for (int k = 0; k < abcValues.length; k++)
                {
                    if(abcValues[k].equalsIgnoreCase(base[index]))
                    {
                        if(k + shift < abcValues.length)
                        {
                            ciphered[index] = abcValues[k + shift];
                        }
                        else
                        {
                            ciphered[index] = abcValues[(abcValues.length - (value + k)) + (shift - 1)];
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

