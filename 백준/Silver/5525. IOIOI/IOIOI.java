import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // Pn에서 n은 IOI가 몇 개 있는지를 의미 e.g. P2 IOIOI -> 2, P3 IOIOIOI -> 3
        int m = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int count = 0;
        int pattern = 0;

        for (int i = 1; i < m - 1; i++) {
            if (arr[i - 1] == 'I' && arr[i] == 'O' && arr[i + 1] == 'I') {
                pattern++;
                i++; // 중복 건너뛰기

                if (pattern >= n) {
                    count++;
                }
            } else {
                pattern = 0;
            }
        }

        System.out.println(count);
    }
}