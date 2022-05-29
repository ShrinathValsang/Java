import java.io.IOException;
import java.util.Scanner;

// Java Program 6
public class JavaDatatypes {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        byte b = (byte) ((Math.pow(2, 8) / 2) - 1);
        short s = (short) ((Math.pow(2, 16) / 2) - 1);
        int i = (int) ((Math.pow(2, 32) / 2) - 1);
        long l = (long) ((Math.pow(2, 64) / 2) - 1);

        for (int j = 0; j < t; j++) {
            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");

                if (x >= -128 && x <= 127) {
                    System.out.println("* byte");
                }

                if (x >= (0 - s - 1) && x <= s) {
                    System.out.println("* short");
                }

                if (x >= (0 - i - 1) && x <= i) {
                    System.out.println("* int");
                }

                if (x >= (0 - l - 1) && x <= l) {
                    System.out.println("* long");
                }
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }

        }
    }
}
