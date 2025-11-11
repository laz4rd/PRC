import java.io.*;

public class Q08 {
    static void readFile() throws IOException {
        FileReader fr = new FileReader("ex.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("An Error occured " + e.getMessage());
        }
    }
}