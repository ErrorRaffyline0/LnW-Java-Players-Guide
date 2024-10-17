import java.util.Scanner;

public class H_TheTriangleFarmer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input base below this line :3");
        Double b = Double.parseDouble(input.nextLine());
        System.out.println("Input height below this line :3");
        Double h = Double.parseDouble(input.nextLine());
        Double area = b * h / 2;
        System.out.println("Area is " + area);
    }
}
