import java.util.Scanner;

public class L_RepairingTheClocktower {
    public static void main(String[] args) {
        Scanner TickTock = new Scanner(System.in);
        System.out.println("input number");
        long number = Long.parseLong(TickTock.nextLine());
        if (number % 2 == 0) {
            System.out.println("Tick");
        }
        else {
            System.out.println("Tock");
        }
    }
}