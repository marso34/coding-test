import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 여기서 8x8로 잘라야 됨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE - 1;

        char[] color = {'W', 'B'};
        char[][] arr = new char[n][];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        } // 입력

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int startBlackCnt = 0;
                int startWhiteCnt = 0;

                for (int k = i; k < i + 8; k++) {
                    int index = k % 2;
                    int index_ = index == 0 ? 1 : 0;

                    for (int l = j; l < j + 8; l++) {
                        index = index == 1 ? 0 : 1;
                        index_ = index_ == 1 ? 0 : 1;

                        if (arr[k][l] != color[index]) {
                            startBlackCnt++;
                        }

                        if (arr[k][l] != color[index_]) {
                            startWhiteCnt++;
                        }
                    }
                }

                int tempMin = Math.min(startBlackCnt, startWhiteCnt);

                min = Math.min(tempMin, min);
            }
        }

        System.out.println(min);
    }
}