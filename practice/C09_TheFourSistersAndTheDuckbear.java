import java.util.Scanner;

public class C09_TheFourSistersAndTheDuckbear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long sisters = 4;
        System.out.println("How many chocolate eggs have been laid?");
        long eggs = Long.parseLong(input.nextLine());
        System.out.println("Each sister will get " + eggs / sisters);
        System.out.println("The duckbear will get " + eggs % sisters);
    }
}
//This is how I calculated the answer to "What are the total egg counts where the duckbear gets more than each
//sister does? You can use the program you created to help you find the answer." The answer is 1, 2, 3, 6, 7 and 11.
//public static void main(String[] args) {
//    long eggs = 1;
//    while (eggs != 2147483647) {
//        if ((eggs % 4) > (eggs / 4)) {
//            System.out.println(eggs + " eggs");
//        }
//        eggs++;
//    }
//}