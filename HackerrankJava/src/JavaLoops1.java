import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Java Program 4
public class JavaLoops1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        bufferedReader.close();

        if (N > 1 && N < 21) {
            for (int i = 1; i < 11; i++) {
                System.out.printf("%d x %d = %d\n", N, i, N*i);
            }
        }
    }
}
