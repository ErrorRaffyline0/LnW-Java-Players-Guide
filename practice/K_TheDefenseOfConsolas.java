import java.awt.Toolkit;
import java.util.Scanner;

public class K_TheDefenseOfConsolas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ANSI_Instr = "\u001B[38;5;208m";
        String ANSI_Reset = "\u001B[0m";
        System.out.println("Target Row?");
        long targetrow = Long.parseLong(input.nextLine());
        System.out.println("Target Column?");
        long targetcol = Long.parseLong(input.nextLine());
        System.out.println(ANSI_Instr + "Deploy to:\n(" + targetrow + ", " + (targetcol - 1) + ")\n" + "(" + (targetrow - 1) + ", " + targetcol + ")\n" + "(" + targetrow + ", " + (targetcol + 1) + ")\n" + "(" + (targetrow + 1) + ", " + targetcol + ")" + ANSI_Reset);
        Toolkit.getDefaultToolkit().beep();
        System.out.println("Visual guide:");
        long miny = (targetrow - Math.abs(targetrow));
        long maxy = (targetrow + Math.abs(targetrow));
        long minx = (targetcol - Math.abs(targetcol));
        long maxx = (targetcol + Math.abs(targetcol));
        long y = (targetrow - Math.abs(targetrow));
        long x = (targetcol - Math.abs(targetcol));
//        long gridy = 8;
//        long gridx = 8;
//        while (x <= maxx) {
//            System.out.print(x);
//            x++;
//        }
//        while (y <= maxy) {
//            y++;
//            System.out.println(y);
//        }
        while (y <= maxy) {
            while (x <= maxx) {
                if (y == targetrow && x == targetcol) {
                    System.out.print("X");
                }
                else if ((y == targetrow && (x == targetcol - 1 || x == targetcol + 1)) || (x == targetcol && (y == targetrow - 1 || y == targetrow + 1))) {
                    System.out.print("O");
                }
                else if (y == miny && x <= 8 && y <= 8) {
                    System.out.print(x);
                }
                else if (x == minx && x <= 8 && y <= 8) {
                    System.out.print(y);
                }
//                else if (x <= gridx && y <= gridy) {
//                    System.out.print("#");
//                }
                else {
                    System.out.print("#");
                }
                x++;
            }
            System.out.print("\n");
            x = minx;
            y++;
        }
    }
}