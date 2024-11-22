package pkg.eindopdracht;
import java.util.Scanner;

public class eindopdracht03 {
    int Lucas(Num n1, Num n2) {

    }

    public void main(String[] args) {
        NaturalInput();
        Lucas(2,1)

    }

    public static int NaturalInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a natural value: ");
        if (!input.hasNextInt()) {
            System.out.println("Not an integer!");
            return NaturalInput();
        }
        if (input.nextInt() <= 0) {
            System.out.println("Value is not positive!");
            return NaturalInput();
        }
        return input.nextInt();
    }

    class Num {
        private int num;

        Num(int newNum) {
            num = newNum;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int newNum) {
            num = newNum;
        }
    }
}