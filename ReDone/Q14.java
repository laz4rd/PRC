import java.io.*;

public class Q14 {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("exa.txt");

            fw.write("Java is PolBaba");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error while writing file " + e.getMessage());
        }
    }
}
