package pkg.exercises;

import java.util.Arrays;

public class C18_TheReplicatorOfDTo {
    public static void main(String[] args) {
        int a = 4;
        int[] Array1 = new int[a];
        int[] Array2 = new int[a];
        a = 0;
        while (a < Array1.length) {
            Array1[a] = C20_TakingANumber.askForNumber("Enter a numerical value to put into array index " + a + ": ");
            Array2[a] = Array1[a];
            a++;
        }
        System.out.println("Array 1 has a length of " + Array1.length + ", and contains values " + Arrays.toString(Array1));
        System.out.println("Array 2 has a length of " + Array2.length + ", and contains values " + Arrays.toString(Array2));
    }
}