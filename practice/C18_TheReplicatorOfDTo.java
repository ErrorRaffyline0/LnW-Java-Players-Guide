import java.util.Arrays;
import java.util.Scanner;

public class C18_TheReplicatorOfDTo {
    public static void main(String[] args) {
        int a = 4;
        int[] Array1 = new int[a];
        int[] Array2 = new int[a];
        a = 0;
        Scanner input = new Scanner(System.in);
        while (a < Array1.length) {
            System.out.print("Enter a numerical value to put into array index " + a + ": ");
            Array1[a] = Integer.parseInt(input.nextLine());
            Array2[a] = Array1[a];
            a++;
        }
        System.out.println("Array 1 has a length of " + Array1.length + ", and contains values " + Arrays.toString(Array1));
        System.out.println("Array 2 has a length of " + Array2.length + ", and contains values " + Arrays.toString(Array2));
    }
}