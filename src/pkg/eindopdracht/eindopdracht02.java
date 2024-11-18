package pkg.eindopdracht;
import java.util.Scanner;

public class eindopdracht02 {
    public static void main(String[] args) {
        int x = CheckInput();
        System.out.println("Sum of all odd numbers until " + x + " integer: " + countup(true, 0, x));
        System.out.println("Sum of all even numbers until " + x + " integer: " + (countup(false, 0, x)));
        System.out.println("Difference between both sums: " + ((countup(true, 0, x)) - (countup(false, 0, x))));
    }

    static int countup(boolean Odd, int min, int max) {
        int a = 0;
        int result = a;
        if (Odd) {
            min++;
        }
        for (a = min - 1; a <= max; a++) {
            a++;
            if (Odd) {
                if (a % 2 != 1) {
                    a++;
                }
            } else { // if method is supposed to count up uneven numbers
                if (a % 2 != 0) {
                    a++;
                }
            }
            if (a > max) { return result; }
            result += a;
        }
        return result;
    }
    static int CheckInput() {
        Scanner input = new Scanner(System.in);
        int x = 0;
        System.out.print("Input an integer: ");
        if (!input.hasNextInt()) {
            System.out.println("Not an integer!");
            CheckInput();
            System.out.print("Input an integer: ");
        }
        x = input.nextInt();
        return x;
    }
}

