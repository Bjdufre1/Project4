import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project4 {

    public static void main(String[] args) {

        File analyzerOutput = new File("input.txt");

        try (Scanner inFile = new Scanner(analyzerOutput)) {

            while (inFile.hasNextLine()) {
                System.out.println(inFile.nextLine());
            }

            inFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
