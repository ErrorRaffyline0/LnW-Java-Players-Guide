package pkg.exercises;

import java.util.Scanner;

public class C13_Watchtower {
    public static void main(String[] args) {
        Scanner location = new Scanner(System.in);
        System.out.println("input x coordinates");
        long x = Long.parseLong(location.nextLine());
        Scanner vertical = new Scanner(System.in);
        System.out.println("input y coordinates");
        long y = Long.parseLong(location.nextLine());
        System.out.print("The enemy is ");
        if (y == 0 && x == 0) {
            System.out.print("here");
        }
        if (y != 0 || x != 0) {
            System.out.print("to the ");
        }
        if (y < 0) {
            System.out.print("south");
        }
        if (y > 0) {
            System.out.print("north");
        }
        if (x < 0) {
            System.out.print("west!");
        }
        if (x == 0) {
            System.out.print("!");
        }
        if (x > 0) {
            System.out.print("east!");
        }
    }
}