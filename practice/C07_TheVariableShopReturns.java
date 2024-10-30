import java.text.DecimalFormat;

public class C07_TheVariableShopReturns {
    public static void main(String[] args) {
        String Childe = "Kaveh";
        int ID = 10000081;
        char initial = 'A';
        byte number = 1;
        double version = 3.6;
        long unix = 1683021600; // Source: https://genshin.hoyoverse.com/en/news/detail/111269
        float hours = 18; // To challenge myself, I wanted to use only the datatypes mentioned in the exercise and no more than that.
        short seconds = 0;
        boolean existence = true;

        // yeah i stole these from the web lol
        java.util.Date time = new java.util.Date(unix * 1000);
        DecimalFormat hour = new DecimalFormat("#");


        if (existence) {
            System.out.println(Childe + " (title: \"Empyrean Reflection\"), " + "is a playable character in Genshin Impact.");
            System.out.println("His character ID is " + ID + ".");
            System.out.println("He lives in " + initial + "lhaitham's house.");
            System.out.println(initial + "lhaitham" + " has " + number + " roommate.");
            System.out.println("Kaveh" + " was released as a playable character with Genshin Impact's banner \"Immaculate Pulse\" in Version " + version + ".");
            System.out.println("The \"Immaculate Pulse\" banner first released to players on Asian servers at " + time + ", with Europeans looking skywards at his Empyrean Reflection at " + (hour.format(hours)) + " hours, " + seconds / 60 + " minutes and " + seconds % 60 + " seconds in the evening."); // Yes this was worth it.
        }
    }
}