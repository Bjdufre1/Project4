import java.io.*;
import java.util.Scanner;

public class Project4 {

    public static int leftParenCount = 0;
    public static int rightParenCount = 0;
    public static int leftCurlyCount = 0;
    public static int rightCurlyCount = 0;
    public static BufferedReader br;

    public static void main(String[] args) throws IOException, ParserError {

        br = new BufferedReader(new FileReader(new File("input.txt")));
        br.readLine();
        if(!br.readLine().equals("beg")){
            throw new ParserError("Program does not begin with a beg statement");
        }
        if(!(Integer.parseInt(br.readLine()) == 31)){
            throw new ParserError("beg needs to be followed by a left curly brace");
        }
        br.readLine();
        leftCurlyCount++;
        int codeOfWord;
        String word;
        while((codeOfWord = Integer.parseInt(br.readLine())) != -1){
            word = br.readLine();
            if(codeOfWord == 42){
                br.readLine();
            }
        }
    }
}
