package pkg.exercises;

import java.util.Scanner;

public class C20_TakingANumber {
    public static void main(String[] args) {
            int result = askForNumber("Thou must give me a number");
            int result2 = askForNumberInRange("Thou must give me a number between 0 and 100 ", 0, 100);
            System.out.println("Method askForNumber returned number " + result);
            System.out.println("Method askForNumberInRange returned number " + result2);
        }
        public static int askForNumber(String text) {
            Scanner number = new Scanner(System.in);
            System.out.println(text);
            return number.nextInt();
        }

        public static int askForNumberInRange(String text, int min, int max) {
            Scanner number = new Scanner(System.in);
            System.out.println(text);
            int askForNumberInRange = number.nextInt();
            while (min > askForNumberInRange || max < askForNumberInRange) {
                System.out.println(text);
                askForNumberInRange = number.nextInt(); }
            return askForNumberInRange;
        }
    }