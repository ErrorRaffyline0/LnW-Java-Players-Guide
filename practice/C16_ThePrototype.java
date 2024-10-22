import java.util.Scanner;

public class C16_ThePrototype {
    public static void main(String[] args) {
        String Pilot = "Raffy";
        String Hunter = "Ajax";
        int number = 0;
        int guessnumber = 0;
        Scanner input = new Scanner(System.in);
        while (number <= 0 || number >= 100) {
            System.out.print(Pilot + ", enter a number between 0 and 100: ");
            number = Integer.parseInt(input.nextLine());
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (guessnumber != number) {
            System.out.print(Hunter + ", guess the number: ");
            guessnumber = Integer.parseInt(input.nextLine());
            if (guessnumber < number) {
                System.out.println(guessnumber + " is too low.");
            }
            if (guessnumber > number) {
                System.out.println(guessnumber + " is too high.");
            }
            if (guessnumber == number) {
                System.out.println("You guessed the number!");
                return;
            }
        }
    }
}