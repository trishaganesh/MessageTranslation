package com.trishawrites;
/**
 * The purpose of this program is to understand how we can use encryption and decryption
 * to essentially translate messages the user enters.
 *
 * @author Trisha Ganesh
 * @version 07/6/2021
 */

import java.util.Scanner;

public class CaesarTester
{
    //char method for alphabet
    public static final char[] theAlphabet = {'A','B','C','D','E','F','G','H','I','J','K','L',
            'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    //main method
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your shift key value (0 - 25): ");
        int shiftValue = in.nextInt();
        if (shiftValue < 0 || shiftValue > 25) {
            System.out.println("Please enter a valid shift key value between 0 and 25: ");
            return;
        }


        System.out.println("-----------------------------------------");

        //printing out the regular and ciphered alphabet
        System.out.println("Regular Alphabet: ");
        for(char ciph : theAlphabet)
        {
            System.out.print(ciph);
        }
        System.out.println();

        System.out.println("Ciphered Alphabet: ");
        //Encryption for Alphabet values
        char[] cipher = Encryption.cipherABCLetters(shiftValue, theAlphabet);
        for(char ciph: cipher)
        {
            System.out.print(ciph);
        }
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("Decrypted Alphabet: ");
        //Decryption for Alphabet values
        System.out.println(Decryption.decryptABCLetters(shiftValue, cipher));
        System.out.println("-----------------------------------------");
        //Using a while loop to display menu results
        // to encrypt, decrypt, or quit with user inputted messages.
        int selection = 0;
        String message = "";
        while(selection != 3)
        {
            System.out.println("Would you like to encyrpt or decrypt a certain message? (or would you prefer to quit " +
                    "the program?)");
            System.out.println("               [1] Encrypt");
            System.out.println("               [2] Decrypt");
            System.out.println("               [3] Quit");
            System.out.print("Please enter your choice based on the number above: ");
            selection = in.nextInt();
            System.out.println();

            if(selection == 0 || selection > 3)
                System.out.println("Please enter an option of 1, 2, or 3.");
            else if(selection == 1)
            {
                System.out.print("Please enter the message that you want to encrypt: ");
                in.nextLine();
                message = in.nextLine();

                String [] messages = new String[message.length()];
                for (int i = 0; i < message.length(); i++)
                    messages[i] = message.substring(i, i+1);
                System.out.println(Encryption.cipherMessage(shiftValue, messages));
            }
            else if(selection == 2)
            {
                System.out.print("Please enter the ciphered message that you want to decrypt: ");
                in.nextLine();
                message = in.nextLine();

                System.out.print("Please enter your shift key value (0 - 25): ");
                shiftValue = in.nextInt();

                String [] messages = new String[message.length()];
                for (int i = 0; i < message.length(); i++)
                    messages[i] = message.substring(i, i+1);
                System.out.println(Decryption.decryptingMessage(shiftValue, messages));
            }
            else if(selection == 3)
            {
                System.out.println("Program ended");
            }
            System.out.println("-----------------------------------------");
        }
    }
}