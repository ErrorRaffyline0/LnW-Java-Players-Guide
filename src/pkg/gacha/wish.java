package pkg.gacha;
import pkg.exercises.C20_TakingANumber;


public class wish {
    public static void main(String[] args) {
        System.out.println("The following featured banners are available:");
        System.out.println("1. Farewell of Snezhnaya");
        int bannernumber  = C20_TakingANumber.askForNumber("What banner do you want to wish on?");
        String banner = "";
        switch (bannernumber) {
            case 1:
                bannernumber = 1;
                System.out.println("You have selected the banner: \"Farewell of Snezhnaya\"");
                break;
        }
    }
    public String FeatBanner(boolean pull, boolean fivestarobtained, boolean fourstarobtained, int FeatBannernum) { // manages pity values and pull amounts, referenced by the wishing system everytime a wish is performed

        if (pull) {
            TotalFeatBannerPulls++;
            if (fivestarobtained) {
                FeatFiveStarPity = 0;
            } else FeatFiveStarPity++;
            if (fourstarobtained) {
                FeatFourStarPity = 0;
            } else FeatFourStarPity = 0;
        }
        if (FeatBannernum == 1) {
            FarewellOfSnezhnaya()

        return Character;
    }
        public class FeatBannerStats {
            public int TotalFeatBannerPulls = 0;
            public int FeatFiveStarPity = 0;
            public int FeatFourStarPity = 0;

        }
        int fates = C20_TakingANumber.askForNumber("Would you like to wish using 1, or 10 Intertwined Fates?");
        switch (fates) {
            case 1:
                FarewellOfSnezhnaya()
        }


    }
}