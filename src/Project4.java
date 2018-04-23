import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project4 {

    public static void main(String[] args) {

        File analyzerOutput = new File("output.txt");

        try (Scanner inFile = new Scanner(analyzerOutput)) {

            while (inFile.hasNextLine()) {
                System.out.println(inFile.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
