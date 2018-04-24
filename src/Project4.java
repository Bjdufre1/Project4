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
            if(codeOfWord == 41){
                switch (word){

                    case ("int"): {
                        if(!(Integer.parseInt(br.readLine()) == 11)){
                            throw new ParserError("int must be followed by an identifier");
                        }
                        br.readLine();
                        if(!(Integer.parseInt(br.readLine()) == 27)){
                            throw new ParserError("int must be assigned on declaration");
                        }
                        br.readLine();
                        int expressionNext = Integer.parseInt(br.readLine());
                        if(expressionNext == 10 || expressionNext == 11) {
                            if(expressionNext == 11){
                                br.readLine();
                                int operator = Integer.parseInt(br.readLine());
                                if(operator != 21 && operator != 22 && operator != 23 && operator != 24){
                                    throw new ParserError("incorrect int assignment");
                                }
                                br.readLine();
                                expressionNext = Integer.parseInt(br.readLine());
                                if(!(expressionNext == 10 || expressionNext == 11)){
                                    throw new ParserError("incorrect int assignment");
                                }
                                br.readLine();
                            }
                            else {
                                br.readLine();
                            }
                        }
                        else {
                            throw new ParserError("Incorrect assignment for int type");
                        }
                        if(!(Integer.parseInt(br.readLine()) == 36)){
                            throw new ParserError("missing semicolon after assignment");
                        }
                        br.readLine();

                    }

                }
            }
        }
    }
}
