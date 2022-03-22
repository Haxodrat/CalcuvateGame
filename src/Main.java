import java.util.Scanner;

public class Main {

    public static int correct = 0;

    public static void main (String[] args) {

        // region instructions

        System.out.println(printInstructions());

        // endregion

        // region 2d arrays

        String[][] stairs = {
                {"1st level", " -> ", " ", " ", " ", " ", " ", "|", "x", "|"},
                {"2nd level", " -> ", " ", " ", " ", " ", " ", "|", "x", "|"},
                {"3rd level", " -> ", " ", " ", " ", " ", " ", "|", "x", "|"},
                {"4th level", " -> ", " ", " ", " ", " ", " ", "|", "x", "|"},
                {"5th level", " -> ", " ", " ", " ", " ", " ", "|", "x", "|"}
        };

        // endregion

        // region variables


        Scanner s1 = new Scanner(System.in);
        int tracker = 1;
        String[] trig = {"cosx", "sinx", "tanx", "secx", "cscx"};

        // endregion

        while (tracker < 6) {

            // region cases
            switch (tracker) {
                case 1:
                    primaryLevel(stairs, s1, trig);
                    tracker++;
                    break;
                case 2:
                    System.out.println("Congrats, you have finished the first level!" +
                            " Here is the second:");
                    secondLevel(stairs, s1, trig);
                    tracker++;
                    break;
                case 3:
                    System.out.println("Congrats, you have finished the second level!" +
                            " Here is the third:");
                    thirdLevel(stairs, s1, trig);
                    tracker++;
                    break;
                case 4:
                    System.out.println("Congrats, you have finished the third level!" +
                            " Here is the fourth:");
                    fourthLevel(stairs, s1, trig);
                    tracker++;
                    break;
                case 5:
                    System.out.println("Congrats, you have finished the fourth level!" +
                            " Here is the fifth:");
                    fifthLevel(stairs, s1, trig);
                    tracker++;
                    System.out.println("Accuracy: " + calculateAccuracy() + "%");
                    System.out.println("Completed");
                    break;
                default:
                    System.out.println("none");
                    break;
            }
            // endregion cases
        }

        // region messages
        System.out.println("Thanks for playing CALCUVATE!!!!");

        // endregion
    }

    //print instructions method
    public static String printInstructions() {
        return
                """
                Welcome to the Calcuvate Game!!!! A game where user, the player, solves problems,  \s
                and for every correct problem, moves up one step. Each level has four steps with a \s
                problem on each one. After the last step, a new set of stairs forms, enabling the  \s
                player to advance to the next level. There are a total of five levels.             \s
                1st: First Derivatives; 2nd: First Integrals; 3rd: Second Derivatives;             \s
                4th: Second Integrals; 5th: Mix of complex derivatives and integrals. After the    \s
                game, the program will print the accuracy of correct answers the player inputted.  \s
                """;
    }

    //build stairs method
    public static void buildStairs(String[][] map) {

        //Build stairs through nested for loops within a method.
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    //first level method -> derivatives
    public static void primaryLevel(String[][] map, Scanner s1, String[] trig) {

        //a counter for amount of problems solved
        int count1 = 1;

        // region while loop
        while (count1 < 6) {

        //nested for loop and if statement to replace "x" with the problem
        for (int j = 0; j < map.length; j++) {
            for (int i = 0; i < map[j].length; i++) {
                if (map[j][i].equals("x")) {

                    String x = generator();
                    map[j][i] = x;
                    buildStairs(map);
                    System.out.println("What is the derivative?");
                    String input = s1.nextLine();

                    if (!isCorrect(input, deriveThis(x, trig))) {
                        System.out.println("Incorrect, the correct answer is " + deriveThis(x, trig));
                        String y1 = generator();
                        System.out.println("What is derivative of " + y1);
                        String subInput = s1.nextLine();

                        if (!isCorrect(subInput, deriveThis(y1, trig))) {
                            System.out.println("Incorrect, the correct answer is " + deriveThis(y1, trig));
                        }
                    }
                    else {
                        //print correct
                        correct++;
                        System.out.println("Correct.");
                    }

                    //increment count
                    count1++;
                }
            }
            }
        }

        //announces end of stage and start of new one
        System.out.println("Congrats. You will now move to the next stage.");
    }

    //second level method -> integrals
    public static void secondLevel(String[][] map, Scanner s1, String[] trig) {

        //a counter for amount of problems solved
        int count2 = 1;

        // region while loop
        while (count2 < 6){

            //assigning values back to x
            map[0][8] = "x";
            map[1][8] = "x";
            map[2][8] = "x";
            map[3][8] = "x";
            map[4][8] = "x";

            //nested for loop and if statement to replace "x" with the problem
            for (int j = 0; j < map.length; j++) {
                for (int i = 0; i < map[j].length; i++) {

                    if (map[j][i].equals("x")) {

                        String x = generator();
                        map[j][i] = x;
                        buildStairs(map);
                        System.out.println("What is the integral? (Answers are up to two decimal places when necessary)");
                        String input = s1.nextLine();

                        if (!isCorrect(input, integrateThis(x))) {
                            System.out.println("Incorrect, the correct answer is " + integrateThis(x));
                            String y1 = generator();
                            System.out.println("What is integral of " + y1);
                            String subInput = s1.nextLine();

                            if (!isCorrect(subInput, integrateThis(y1))) {
                                System.out.println("Incorrect, the correct answer is " +
                                        integrateThis(y1));
                            }
                            else {
                                System.out.println("Correct.");
                            }
                        }
                        else {
                            //print correct
                            correct++;
                            System.out.println("Correct.");
                        }

                        //increment count
                        count2++;
                    }
                }
            }
        }

        //announces end of stage and start of new one
        System.out.println("Congrats. You will now move to the next stage.");
    }

    //third level method -> second derivatives
    public static void thirdLevel(String[][] map, Scanner s1, String[] trig) {

        //a counter for amount of problems solved
        int count3 = 1;

        // region while loop
        while (count3 < 6) {

            //assigning values back to x
            map[0][8] = "x";
            map[1][8] = "x";
            map[2][8] = "x";
            map[3][8] = "x";
            map[4][8] = "x";

            //nested for loop and if statement to replace "x" with the problem
            for (int j = 0; j < map.length; j++) {
                for (int i = 0; i < map[j].length; i++) {
                    if (map[j][i].equals("x")) {

                        String x = generator();
                        map[j][i] = x;
                        buildStairs(map);
                        System.out.println("What is the second derivative?");
                        String input = s1.nextLine();

                        if (!isCorrect(input, deriveThis(deriveThis(x, trig), trig))) {
                            System.out.println("Incorrect, the correct answer is " +
                                    deriveThis(deriveThis(x, trig), trig));
                        }
                        else {
                            //print correct
                            correct++;
                            System.out.println("Correct.");
                        }

                        //increment count
                        count3++;
                    }
                }
            }
        }

        //announces end of stage and start of new one
        System.out.println("Congrats. You will now move to the next stage.");
    }

    //fourth level method -> trigonometric functions
    public static void fourthLevel(String[][] map, Scanner s1, String[] trig) {

        //a counter for amount of problems solved
        int count4 = 1;
        int k = 0;

        // region while loop
        while (count4 < 6){

            //assigning values back to x
            map[0][8] = "x";
            map[1][8] = "x";
            map[2][8] = "x";
            map[3][8] = "x";
            map[4][8] = "x";

            //nested for loop and if statement to replace "x" with the problem
            for (int j = 0; j < map.length; j++) {
                for (int i = 0; i < map[j].length; i++) {

                        if (map[j][i].equals("x")) {

                            String x = trig[k];
                            map[j][i] = x;
                            buildStairs(map);
                            System.out.println("What is the derivative?");
                            String input = s1.nextLine();

                            if (!isCorrect(input, deriveThis(x, trig))) {
                                System.out.println("Incorrect, the correct answer is " +
                                        deriveThis(x, trig));
                                k++;
                            } else {
                                //print correct
                                correct++;
                                System.out.println("Correct.");
                                k++;
                            }

                            //increment count
                            count4++;
                        }
                }
            }
        }

        //announces end of stage and start of new one
        System.out.println("Congrats. You will now move to the next stage.");
    }

    //fifth level method -> mix 'em
    public static void fifthLevel(String[][] map, Scanner s1, String[] trig) {

        //a counter for amount of problems solved
        int count5 = 1;
        String x;

        // region while loop
        while (count5 < 6){

            //assigning values back to x
            map[0][8] = "x";
            map[1][8] = "x";
            map[2][8] = "x";
            map[3][8] = "x";
            map[4][8] = "x";

            //nested for loop and if statement to replace "x" with the problem
            for (int j = 0; j < map.length; j++) {
                for (int i = 0; i < map[j].length; i++) {
                    if (map[j][i].equals("x")) {

                        int k = (int) (Math.random() * 4);
                        int probability = (int)(Math.random() * 4 + 1);
                        if (probability == 4) {
                            x = trig[k];
                        }
                        else {
                            x = generator();
                        }
                        map[j][i] = x;
                        buildStairs(map);

                        switch (probability) {
                            case 1:
                                System.out.println("What is the derivative?");
                                String input1 = s1.nextLine();

                                if (!isCorrect(input1, deriveThis(x, trig))) {
                                    System.out.println("Incorrect, the correct answer is " +
                                            deriveThis(x, trig));
                                    String y1 = generator();
                                    System.out.println("What is derivative of " + y1);
                                    String subInput1 = s1.nextLine();

                                    if (!isCorrect(subInput1, deriveThis(y1, trig))) {
                                        System.out.println("Incorrect, the correct answer is " + deriveThis(y1, trig));
                                    }
                                }
                                else {
                                    //print correct
                                    correct++;
                                    System.out.println("Correct.");
                                }
                                break;
                            case 2:
                                System.out.println("What is the integral?");
                                String input2 = s1.nextLine();

                                if (!isCorrect(input2, integrateThis(x))) {
                                    System.out.println("Incorrect, the correct answer is " + integrateThis(x));
                                    String y1 = generator();
                                    System.out.println("What is integral of " + y1);
                                    String subInput2 = s1.nextLine();

                                    if (!isCorrect(subInput2, integrateThis(y1))) {
                                        System.out.println("Incorrect, the correct answer is " + integrateThis(y1));
                                    }
                                } else {
                                    //print correct
                                    correct++;
                                    System.out.println("Correct.");
                                }
                                break;
                            case 3:
                                System.out.println("What is the second derivative?");
                                String input3 = s1.nextLine();

                                if (!isCorrect(input3, deriveThis(deriveThis(x, trig), trig))) {
                                    System.out.println("Incorrect, the correct answer is " + deriveThis(deriveThis(x, trig), trig));
                                }
                                else {
                                    //print correct
                                    correct++;
                                    System.out.println("Correct.");
                                }
                                break;
                            case 4:
                                System.out.println("What is the derivative?");
                                String input = s1.nextLine();

                                if (!isCorrect(input, deriveThis(x, trig))) {
                                    System.out.println("Incorrect, the correct answer is " + deriveThis(x, trig));
                                }
                                else {
                                    //print correct
                                    correct++;
                                    System.out.println("Correct.");
                                }
                                break;
                            default:
                                System.out.println("none");
                                break;
                        }

                        //increment count
                        count5++;
                    }
                }
            }
        }
        // endregion while loop
    }

    //isCorrect method
    public static boolean isCorrect(String input, String sol) {

        if (input.equals(sol)) {
            return true;
        }
        return false;
    }

    //Accuracy method
    public static double calculateAccuracy() {
        return (Math.floor((double) correct / 25 * 100) / 100.0) * 100;
    }

    //Random problem generator method
    public static String generator() {
        int negative = (int)(Math.random() * 3 + 1);
        int plus = (int)(Math.random() * 2 + 1);
        int A = (int)(Math.random() * 20 + 1);
        int B = (int)(Math.random() * 20);
        int C = (int)(Math.random() * 20 + 1);
        int D = (int)(Math.random() * 20);
        if (negative == 1) {
            A *= -1;
            C *= -1;
        }
        else if (negative == 2){
            B *= -1;
            D *= -1;
        }

        String strA = String.valueOf(A);
        String strB = String.valueOf(B);
        String strC = String.valueOf(C);
        String strD = String.valueOf(D);
        if (plus == 1)
        {
            return strA + "x^" + strB;
        }
        return strA + "x^" + strB + "+" + strC + "x^" + strD;
    }

    //Derivative method
    public static String deriveThis(String problem, String[] trig) {

        //declare variables
        int coeff;
        int exponent;
        int output1;
        int coeff2;
        int exponent2;
        int output2;

        for (int k = 0; k < trig.length; k++) {
            if (problem.equals(trig[k])) {
                switch (k) {
                    case 0:
                        return "-sinx";
                    case 1:
                        return "cosx";
                    case 2:
                        return "sec^2x";
                    case 3:
                        return "secxtanx";
                    case 4:
                        return "-cscxcotx";
                    default:
                        break;
                }
            }
        }

        // region outer for loop
        for (int i = 0; i < problem.length(); i++) {

            if (problem.equals("0")) {
                return "0";
            }
            if (problem.equals(String.valueOf(1))) {
                return String.valueOf(0);
            }

            // region outer if statement
            if (problem.substring(i, i+1).equals("x")){
                if (!problem.substring(0, 2).equals("1+")) {
                    coeff = Integer.parseInt(problem.substring(0, i));
                }
                else {
                    coeff = 1;
                }

                 // region if no plus
                 if (!problem.contains("+")) {
                     exponent = Integer.parseInt(problem.substring(i + 2));
                     output1 = coeff * exponent;
                     exponent -= 1;

                     if (output1 == 0) {
                         return String.valueOf(0);
                     }

                     if (exponent == 0) {
                         return String.valueOf(1);
                     }

                     return String.valueOf(output1) + "x^" + String.valueOf(exponent);
                 }
                 // endregion if no plus

                 else {

                     if (problem.substring(0, 2).equals("1+")) {
                         coeff2 = Integer.parseInt(problem.substring(2, problem.indexOf('x')));
                         exponent2 = Integer.parseInt(problem.substring(problem.indexOf('x') + 2));
                         output2 = coeff2 * exponent2;
                         exponent2--;
                         return String.valueOf(0) + String.valueOf(output2) + "x^" + String.valueOf(exponent2);
                     }
                     if (problem.substring(problem.length() - 1).equals("+1")) {
                         coeff = Integer.parseInt(problem.substring(0, problem.indexOf('x')));
                         exponent = Integer.parseInt(problem.substring(problem.indexOf('x') + 2, problem.length() - 1));
                         output1 = coeff * exponent;
                         exponent--;
                         return String.valueOf(output1) + "x^" + String.valueOf(exponent);
                     }

                     // region inner for loop
                     for (int c = 0; c< problem.length();c++)
                     {

                         if (problem.substring(c, c+1).equals("+")) {

                             for (int j = c; j < problem.length(); j++) {

                                 if (problem.substring(j, j + 1).equals("x")) {
                                     exponent = Integer.parseInt(problem.substring(i+2, c));
                                     output1 = coeff * exponent;
                                     coeff2 = Integer.parseInt(problem.substring(c+1, j));
                                     exponent2 = Integer.parseInt(problem.substring(j + 2));
                                     output2 = coeff2 * exponent2;

                                     exponent -= 1;
                                     exponent2 -= 1;

                                     if (output1 == 0 && output2 == 0) {
                                         return String.valueOf(0);
                                     }
                                     if (output1 == 0) {
                                         if (exponent2 == 0) {
                                             return String.valueOf(1);
                                         }
                                         return String.valueOf(output2) + "x^" +
                                                 String.valueOf(exponent2);
                                     }
                                     if (output2 == 0) {
                                         if (exponent == 0) {
                                             return String.valueOf(1);
                                         }
                                         return String.valueOf(output1) + "x^" +
                                                 String.valueOf(exponent);
                                     }
                                     if (exponent == 0 && exponent2 == 0) {
                                         return String.valueOf(2);
                                     }
                                     if (exponent == 0) {
                                         return String.valueOf(1) + "+" + String.valueOf(output2) +
                                                 "x^" + String.valueOf(exponent2);
                                     }
                                     if (exponent2 == 0) {
                                         return String.valueOf(output1) + "x^" +
                                                 String.valueOf(exponent) + "+" + String.valueOf(1);
                                     }

                                     return String.valueOf(output1) + "x^" + String.valueOf(exponent) +
                                             "+" + String.valueOf(output2) + "x^" +
                                             String.valueOf(exponent2);
                                 }
                             }

                         }
                     }
                     // endregion inner for loop
                 }
            }
            // endregion outer if statement

        }
        // endregion outer for loop

        return "not solvable";
    }

    //Integral method
    public static String integrateThis(String problem) {

        int coeff;
        int exponent;
        double output1;
        int coeff2;
        int exponent2;
        double output2;

        for (int j = 0; j < problem.length(); j++) {

            if (problem.substring(j, j + 1).equals("x")) {
                coeff = Integer.parseInt(problem.substring(0, j));

                if (!problem.contains("+")) {

                    exponent = Integer.parseInt(problem.substring(j + 2));
                    exponent++;

                    if (exponent == 0) {
                        return "lnx";
                    }

                    output1 = (Math.floor(((double) coeff / exponent) * 100) / 100.0);
                    return String.valueOf(output1) + "x^" + String.valueOf(exponent);
                }

                else{

                    for (int c = 0; c < problem.length(); c++){

                        if (problem.substring(c, c+1).equals("+")){

                            for (int k = c; k < problem.length(); k++){

                                if (problem.substring(k, k+1).equals("x")){
                                    exponent = Integer.parseInt(problem.substring(j+2, c));
                                    coeff2 = Integer.parseInt(problem.substring(c+1, k));
                                    exponent2 = Integer.parseInt(problem.substring(k+2));
                                    exponent++;
                                    exponent2++;

                                    if (exponent == 0 && exponent2 == 0) {
                                        return "2lnx";
                                    }
                                    if (exponent == 0) {
                                        return "lnx" + "+" + String.valueOf(Math.floor(((double) coeff2 /exponent2) * 100) / 100.0);
                                    }
                                    if (exponent2 == 0) {
                                        return String.valueOf(Math.floor(( (double) coeff /exponent) * 100) / 100.0) + "+" + "lnx";
                                    }

                                    output1 = (Math.floor(( (double) coeff /exponent) * 100) / 100.0);
                                    output2 = (Math.floor(( (double) coeff2 /exponent2) * 100) / 100.0);
                                    String out1 = String.valueOf(output1);
                                    String out2 = String.valueOf(output2);

                                    return out1 + "x^" + String.valueOf(exponent) + "+" + out2 + "x^" + String.valueOf(exponent2);
                            }
                        }
                    }
                }
            }
            }
        }
        return "is not solvable";
    }
}
