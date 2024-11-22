package pkg.eindopdracht;
import java.util.Scanner;

public class eindopdracht02 {

    public static void main(String[] args) {
        boolean JobDone = false;
        int start = 0;
        int max = 0;

        while (!JobDone) {
            System.out.println("Specifying a starting value...");
            start = CheckInput();
            System.out.println("Specifying a maximum value...");
            max = CheckInput();
            if (max < start) {
                System.out.println("Maximum value is not allowed be higher than starting value!");
            }
            else {
                JobDone = true;
            }
        }

        System.out.println("Sum of all odd numbers from " + start + " until " + max + ": " + countup(true, start, max));
        System.out.println("Sum of all even numbers from " + start + " until " + max + ": " + (countup(false, start, max)));
        System.out.println("Difference between both sums: " + ((countup(true, start, max)) - (countup(false, start, max))));
    }

    /* "Odd" specifies whether the method is instructed calculate the sum of odd or even numbers
        "start" specifies the starting point from which to start counting
        "max" specifies the maximum value to count up towards */
    static int countup(boolean Odd, int start, int max) {
        int a = 0;
        int result = a;
        /*
        "a" starts at starting value (-1) because of the for loop including a++; at the start
        while the current number is below the maximum value, we can keep counting upwards
        */
        for (a = start; a <= max; a++) {
            // to only include odd numbers in the sum, we correct the starting value if it is even
            if (Odd) {
                if (a % 2 != 1) {
                    a++;
                }
            }
            // to only include even numbers (if !Odd) in the sum, we correct the starting value if it is uneven
            else {
                if (a % 2 != 0) {
                    a++;
                }
            }
            if (a > max) {
                return result;
            }

            if (a >= 0 && a > result + a && !OverflowCheck) {
                System.out.println("Warning: integer overflow detected!");
                OverflowCheck = true;
            }
            if (a <= 0 && a < result + a && !UnderflowCheck) {
                System.out.println("Warning: integer underflow detected!");
                UnderflowCheck = true;
            }

            result += a;

        }
        return result;
    }

    public static boolean OverflowCheck = false;
    public static boolean UnderflowCheck = false;

    public static int CheckInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input an integer: ");
        if (!input.hasNextInt()) {
            System.out.println("Not an integer!");
            return CheckInput();
        }
        return input.nextInt();
    }
}

