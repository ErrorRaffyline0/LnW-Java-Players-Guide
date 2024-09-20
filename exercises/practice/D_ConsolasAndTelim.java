import java.util.Scanner;

public class D_ConsolasAndTelim
{
    public static void main(String[] args)
    {
        Scanner Bakery = new Scanner(System.in);
        System.out.println("Bread is ready.");
        System.out.println("Who is the bread for?");

        String Name = Bakery.nextLine();
        System.out.println("Noted: " + Name + " got bread.");
    }
}