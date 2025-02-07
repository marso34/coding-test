import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] zero = new int[n + 1];
            int[] one = new int[n + 1];

            if (n == 0) {
                System.out.println("1 0");
                continue;
            } else if (n == 1) {
                System.out.println("0 1");
                continue;
            }

            zero[0] = 1;
            one[1] = 1;

            for (int j = 2; j <= n; j++) {
                zero[j] = zero[j - 1] + zero[j - 2];
                one[j] = one[j - 1] + one[j - 2];
            }

            System.out.println(zero[n] + " " + one[n]);
        }
    }
}