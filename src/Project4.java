import java.io.*;

public class Project4 {

    public static int leftParenCount = 0;
    public static int rightParenCount = 0;
    public static int leftCurlyCount = 0;
    public static int rightCurlyCount = 0;
    public static boolean hasEnd = false;
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
            else if(codeOfWord == 25){
                leftParenCount++;
            }
            else if(codeOfWord == 26){
                rightParenCount++;
            }
            else if(codeOfWord == 31){
                leftCurlyCount++;
            }
            else if(codeOfWord == 32){
                rightCurlyCount++;
            }
            else if(codeOfWord == 11){
                int hold = Integer.parseInt(br.readLine());
                if(hold != 27){
                    throw new ParserError("Hanging variable");
                }
                br.readLine();
            }
            if(codeOfWord == 41){
                switch (word) {

                    case ("int"): {
                        if (!(Integer.parseInt(br.readLine()) == 11)) {
                            throw new ParserError("int must be followed by an identifier");
                        }
                        br.readLine();
                        if (!(Integer.parseInt(br.readLine()) == 27)) {
                            throw new ParserError("int must be assigned on declaration");
                        }
                        br.readLine();
                        int expressionNext = Integer.parseInt(br.readLine());
                        if (expressionNext == 10 || expressionNext == 11) {
                            if (expressionNext == 11) {
                                br.readLine();
                                int operator = Integer.parseInt(br.readLine());
                                if (operator != 21 && operator != 22 && operator != 23 && operator != 24) {
                                    throw new ParserError("Incorrect int assignment");
                                }
                                br.readLine();
                                expressionNext = Integer.parseInt(br.readLine());
                                if (!(expressionNext == 10 || expressionNext == 11)) {
                                    throw new ParserError("Incorrect int assignment");
                                }
                                br.readLine();
                            } else {
                                br.readLine();
                            }
                        } else {
                            throw new ParserError("Incorrect assignment for int type");
                        }
                        if (!(Integer.parseInt(br.readLine()) == 36)) {
                            throw new ParserError("Missing semicolon after assignment");
                        }
                        br.readLine();
                        break;

                    }
                    case ("pnt"): {
                        if (!(Integer.parseInt(br.readLine()) == 25)) {
                            throw new ParserError("pnt must be followed by a left paren");
                        }
                        br.readLine();
                        leftParenCount++;
                        int code = Integer.parseInt(br.readLine());
                        if (code == 39) {
                            br.readLine();
                            code = Integer.parseInt(br.readLine());
                            br.readLine();
                            while (code != 39) {
                                code = Integer.parseInt(br.readLine());
                                br.readLine();
                            }
                            br.mark(1000);
                            if (Integer.parseInt(br.readLine()) == 45) {
                                br.readLine();
                                int hold = Integer.parseInt(br.readLine());
                                if (!(hold == 11 || hold == 39)) {
                                    throw new ParserError("Incorrect assignment for string");
                                }
                                br.readLine();
                            } else {
                                br.reset();
                            }
                        } else if (code == 11) {
                            br.readLine();
                            br.mark(1000);
                            if (Integer.parseInt(br.readLine()) == 45) {
                                br.readLine();
                                int hold = Integer.parseInt(br.readLine());
                                if (!(hold == 11 || hold == 39)) {
                                    throw new ParserError("Incorrect assignment for string");
                                }
                                br.readLine();
                            } else {
                                br.reset();
                            }
                        }
                        int num = Integer.parseInt(br.readLine());
                        if (num == 26) {
                            rightParenCount++;
                        }
                        br.readLine();
                        int number = Integer.parseInt(br.readLine());
                        if (number != 36) {
                            throw new ParserError("Not ended with semicolon");
                        }
                        br.readLine();

                        break;
                    }
                    case ("if"): {
                        if (!(Integer.parseInt(br.readLine()) == 25)) {
                            throw new ParserError("if must be followed by a left paren");
                        }
                        br.readLine();
                        leftParenCount++;
                        int hold = Integer.parseInt(br.readLine());
                        if (!(hold == 11 || hold == 10)) {
                            throw new ParserError("if statement must contain variable or literal");
                        }
                        br.readLine();
                        hold = Integer.parseInt(br.readLine());
                        if (!(hold == 29 || hold == 30 || hold == 27)) {
                            throw new ParserError("if statement must be less than, greater than, equals, or a boolean");
                        }
                        br.readLine();
                        hold = Integer.parseInt(br.readLine());
                        if (!(hold == 11 || hold == 10)) {
                            throw new ParserError("if statement must contain variable or literal after operand");
                        }
                        br.readLine();
                        int num = Integer.parseInt(br.readLine());
                        if (num == 26) {
                            rightParenCount++;
                        }
                        br.readLine();
                        num = Integer.parseInt(br.readLine());
                        if (num == 31) {
                            leftCurlyCount++;
                        } else {
                            throw new ParserError("if must end with a curly");
                        }
                        br.readLine();
                        break;
                    }

                    case ("end"): {
                        hasEnd = true;
                        break;
                    }
                }
            }
        }
        if(leftCurlyCount != rightCurlyCount){
            throw new ParserError("Curly braces do not match");
        }
        if(rightParenCount != leftParenCount){
            throw new ParserError("Parenthesis do not match");
        }
        if(!hasEnd) {
            throw new ParserError("No end statement");
        }
        System.out.println("Parser Check Passed");
    }

}
