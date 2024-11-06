import java.util.Scanner;

public class C10_TheDominionOfKings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String username = input.nextLine();
        System.out.println("Welcome, King " + username + "!");
        System.out.println("How many provinces do you rule?");
        long provinces = Long.parseLong(input.nextLine());
        System.out.println("How many duchies do you rule?");
        long duchies = Long.parseLong(input.nextLine());
        System.out.println("How many estates do you rule?");
        long estates = Long.parseLong(input.nextLine());
        System.out.println("Excellent! Your kingdom's greatness score is " + (6 * provinces + 3 * duchies + 1 * estates));
        System.out.println("Would you like to calculate another King's score? (Y/N)");
        String YesOrNo = input.nextLine();
        if (YesOrNo.equals("Y") || YesOrNo.isEmpty()) {
            main(new String[] {});
        }
        else
            return;
    }
}