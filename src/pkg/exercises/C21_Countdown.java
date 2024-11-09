package pkg.exercises;

public class C21_Countdown {
    public static void main(String[] args) {
        int result = min(10);
        System.out.println(result);
    }

    public static int min(int k) {
        if (k > 1) {
            return min(k - 1);
        } else
            return 1;
    }
}