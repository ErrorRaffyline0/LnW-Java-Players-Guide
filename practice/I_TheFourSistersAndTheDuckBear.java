import java.util.Scanner;

public class I_TheFourSistersAndTheDuckBear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long sisters = 4;
        System.out.println("How many chocolate eggs have been laid?");
        long eggs = Long.parseLong(input.nextLine());
        System.out.println("Each sister will get " + eggs / sisters);
        System.out.println("The duckbear will get " + eggs % sisters);
    }
}