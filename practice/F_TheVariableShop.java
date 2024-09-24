import java.text.DecimalFormat;

public class TheVariableShop {
    public static  void main(String[] args) {
        String Childe = "Tartaglia";
        int ID = 10000033;
        char initial = 'A';
        byte number = 11;
        double version = 1.1;
        long unix = 1605062217; // Source: https://twitter.com/GenshinImpact/status/1326353188803375109
        float hours = 3; // To challenge myself, I wanted to use only the datatypes mentioned in the exercise and no more than that.
        short seconds = 2217;
        boolean existence = true;

        // yeah i stole these from the web lol
        java.util.Date time = new java.util.Date(unix * 1000);
        DecimalFormat hour = new DecimalFormat("#");

        if (existence) {
            System.out.println(Childe + " (codename \"Childe\"), " + "is a playable character in Genshin Impact.");
            System.out.println("His character ID is " + ID + ".");
            System.out.println("His family name is " + initial + "jax.");
            System.out.println(Childe + " is No. " + number + " of the Fatui Harbingers.");
            System.out.println("Childe" + " was released as a playable character with Genshin Impact's Version " + version + " update.");
            System.out.println("The Version "+version+" update released to players worldwide at "+time+", with Europeans waking up to a Childe at "+(hour.format(hours))+" hours, "+seconds / 60+" minutes and "+seconds % 60+" seconds in the morning."); // Yes this was wo
        }
    }
}
