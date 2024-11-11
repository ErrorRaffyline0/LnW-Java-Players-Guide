package pkg.eindopdracht.gacha;
import pkg.exercises.C20_TakingANumber;


public class wish {
    public static void main(String[] args) {
        System.out.println("The following featured banners are available:");
        System.out.println("1. Farewell of Snezhnaya");
        int FeatBannerNum = C20_TakingANumber.askForNumber("What banner do you want to wish on?");
        switch (bannernumber) {
            case 1:
                bannernumber = 1;
                System.out.println("You have selected the banner: \"Farewell of Snezhnaya\"");
                FarewellOfSnezhnaya();
                break;
        }
    }

    public static Float FeatBannerOdds(boolean RateUpFiveStar, boolean RateUpFourStar, int FiveStarPity, int FourStarPity) { // manages odds, referenced by the banner
        float RateUpOverRegOdds = 0.5F
        if (FiveStarPity < 74) {
            float FiveStarOdds = 0.006F;
        }
    }

    public static int FeatBannerPulls(int Pulls) {
        int TotalPulls;
        int RateUpFiveStar;
        int RegFiveStar;
        int RateUpFourStar;
        int RegFourStar;
        int FiveStarPity;
        int FourStarPity;
    }
}