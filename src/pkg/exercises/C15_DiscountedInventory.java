package pkg.exercises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class C15_DiscountedInventory {
    public static void main(String[] args){
        System.out.println("The following items are available:");
        System.out.println("1. Rope");
        System.out.println("2. Torches");
        System.out.println("3. Climbing Equipment");
        System.out.println("4. Clean Water");
        System.out.println("5. Machete");
        System.out.println("6. Canoe");
        System.out.println("7. Food Supplies");
        int itemnumber = C20_TakingANumber.askForNumberInRange("What number do you want to see the price of?",1,7);
        String item = "";
        switch (itemnumber) {
            case 1:
                item = "Rope";
                break;
            case 2:
                item = "Torches";
                break;
            case 3:
                item = "Climbing Equipment";
                break;
            case 4:
                item = "Clean Water";
                break;
            case 5:
                item = "Machete";
                break;
            case 6:
                item = "Canoe";
                break;
            case 7:
                item = "Food Supplies";
                break;
        }
        double price = 0;
        DecimalFormat gold = new DecimalFormat("#.##");
        switch (item) {
            case "Rope":
                price = 10;
                break;
            case "Torches":
                price = 15;
                break;
            case "Climbing Equipment":
                price = 25;
                break;
            case "Clean Water":
                price = 1;
                break;
            case "Machete":
                price = 20;
                break;
            case "Canoe":
                price = 200;
                break;
            case "Food Supplies":
                price = 1;
                break;
        }
        Scanner name = new Scanner(System.in);
        System.out.println("By the way, what is your name?");
        String user = name.nextLine();
        switch (user) {
            case "Raffy":
                price = price / 2;
                break;
            }
        System.out.println(item + " cost " + (gold.format(price)) + " gold.");
    }
}