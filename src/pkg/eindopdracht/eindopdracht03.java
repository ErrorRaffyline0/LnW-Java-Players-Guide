package pkg.eindopdracht;
import java.util.Scanner;

public class eindopdracht03 {
    public static void main(String[] args) {
        int n = NaturalInput();
        Lucas(n);
    }

    public static int NaturalInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a natural value: ");
        if (!input.hasNextInt()) {
            System.out.println("Not an integer!");
            return NaturalInput();
        }
        int n = input.nextInt();
        if (n <= 0) {
            System.out.println("Value is not positive!");
            return NaturalInput();
        }
        if (n > 23) {
            System.out.println("Natural value will result in integer overflow during Lucas number calculation!");
            return NaturalInput();
        }
        return n;
    }

    public static void Lucas(int n) {
        int a = 2;
        int b = 1;
        System.out.println("De eerste " + n + " Lucas-getallen:\n");
        if (n > 1) {
            System.out.print(a + " ");
        }
        if (n > 2) {
            System.out.print(b + " ");
        }
        for (int i = 3; n >= i; System.out.print((b += a) + " ")) {
            System.out.print((a += b) + " ");
            i++;
        }
    }
}
