package Original;
// Write a Java program to create a text file named example.txt and 

// write "Hello Java File Handling!" inside it.

import java.io.*;

public class Question14 {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("example.txt");

            fw.write("Welcome to File Handling");
            fw.close();
            System.out.println("Completed");

        } catch (IOException e) {
            System.out.println("Had an Error trying");
        }
    }
}