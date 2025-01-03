import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 참가자 수 N

        String[] input = br.readLine().split(" ");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 티셔츠 T장
        int P = Integer.parseInt(st.nextToken()); // 펜 P자루

        int result = 0;

        for (String s : input) {
            int c = Integer.parseInt(s);

            if (c == 0) continue;

            result += c / T;

            if (c % T != 0) {
                result += 1;
            }
        }

        System.out.println(result);
        System.out.println(N / P + " " + N % P);
    }
}