package pkg.exercises;

public class C17_TheMagicCannon {
    public static void main(String[] args) {
        int crank = 1;
        while (crank <= 100) {
            String result;
            String ANSI_Result;
            String ANSI_Reset = "\u001B[0m";
            if (crank % 3 == 0) {   // I tried to swap around locations for if and else and == and != statements to see which order would theoretically be the most efficient, but honestly I give up cuz who is going to care about this. Although this might actually be the most efficient way to do this (unless you count using a ton of result++'s and result prints in between them and looping it)
                if (crank % 5 != 0) {
                    result = "Fire";
                    ANSI_Result = "\u001B[38;5;166m"; } // crazy how there are no simple online tools to convert sRGB or HEX color values to the closest matching ANSI color, had to use some weird bash script from github to convert the specific colors from a webpage that i wanted to use here (yeah idk why i bothered either)
                else {
                    result = "Combined";
                    ANSI_Result = "\u001B[38;5;168m"; }
            }
            else if (crank % 5 != 0) {
                result = "Normal";
                ANSI_Result = ANSI_Reset; }
            else {
                result = "Electric";
                ANSI_Result = "\u001B[38;5;177m"; }
            System.out.println(crank + ": " + ANSI_Result + result + ANSI_Reset);
            crank++;
        }
    }
}