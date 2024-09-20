import java.util.Scanner;

public class E_TheThingNamer
{
public static void main(String[] args)
    {
    System.out.println("What kind of thing are we talking about?");
    Scanner input = new Scanner(System.in);
    String a = input.nextLine(); // Stores type of the thing from user input. I changed input.next() to input.nextLine because otherwise input can only be one word.
    System.out.println("How would you describe it? Big? Azure? Tattered?");
    String b = input.nextLine(); // Stores attribute description of the thing from user input
    String c = "Doom"; // Stores property of the thing
    String d = "3000"; // Stores revision of the thing
    System.out.println("The " + b + " " + a + " of " + c + " " + d + "!");
    }
}

// To make the code more understandable, it would make more sense if the Scanner was the first statement in main, since it's used multiple times anyway.