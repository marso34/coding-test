import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String dir = br.readLine();    

        int currentX = 0;
        int currentY = 0;
        long sum = 1;

        for (int i = 0; i < k; i++) {
            char direction = dir.charAt(i);

            if (direction == 'U') {
                currentX--;
            } else if (direction == 'D') {
                currentX++;
            } else if (direction == 'L') {
                currentY--;
            } else if (direction == 'R') {
                currentY++;
            }

            sum += getValue(n, currentX, currentY);
        }

        System.out.println(sum);
    }

    private static long getValue(long n, long x, long y) {
        // 몇 번째 줄인지
        long line = x + y;
        long sum = 0L;

        if (line <= n) {
            sum = line * (line + 1) / 2;
        } else { // line이 n보다 커지면 2개의 등차수열
            long temp = n * (n + 1) / 2;
            sum = temp + (line - n) * (3 * n - line - 1) / 2;
        }

        // 줄에서 몇 번째인지
        long cnt = 0L;

        if (line + 1 >= n) {
            long temp = line + 1 - n;

            x -= temp;
            line -= temp * 2; // 한 줄에 있는 숫자의 개수
        }

        cnt = line % 2 == 0 ? line - x + 1 : x + 1;

        return sum + cnt;
    }
}