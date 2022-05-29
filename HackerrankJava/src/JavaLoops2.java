import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// Java Program 5
public class JavaLoops2 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            printSeries(a, b, n);
        }

    }

    private static void printSeries(int a, int b, int n) {
        double sum = 0;
        for (int j = 0; j < n; j++) {
            double d = Math.pow(2, j) * b;
            sum += d;
            System.out.print((int) (a + sum) + " ");
        }
    }
}
