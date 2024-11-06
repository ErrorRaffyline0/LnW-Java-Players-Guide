public class C16_ThePrototype {
    public static void main(String[] args) {
        String Pilot = "Raffy";
        String Hunter = "Ajax";
        int number = C20_TakingANumber.askForNumberInRange(Pilot + ", enter a number between 0 and 100: ", 0, 100);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        int guessnumber = C20_TakingANumber.askForNumber(Hunter + ", guess the number: ");
        while (guessnumber != number) {
            guessnumber = C20_TakingANumber.askForNumber(Hunter + ", guess the number: ");
            if (guessnumber < number) {
                System.out.println(guessnumber + " is too low.");
            }
            if (guessnumber > number) {
                System.out.println(guessnumber + " is too high.");
            }
        }
        System.out.println("You guessed the number!");
    }
}