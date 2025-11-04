// Write a Java program with a method readFile() that declares throws
// IOException. Handle this exception in the main() method.

import java.io.*;  // for IOException and FileReader

public class Question8 {

    // Method that declares "throws IOException"
    static void readFile() throws IOException {
        // Attempt to open a file that may not exist
        FileReader fr = new FileReader("example.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

    public static void main(String[] args) {
        try {
            readFile();  // may throw IOException
        } 
        catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        System.out.println("Program continues normally...");
    }
}
