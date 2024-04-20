import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int n1 = a;
        int n2 = b;

        int gcd = 0;

        while (true) {
            int r = n1 % n2;

            if (r == 0) {
                gcd = n2;
                break;
            }

            n1 = n2;
            n2 = r;
        }

        int lcm = (a * b) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}