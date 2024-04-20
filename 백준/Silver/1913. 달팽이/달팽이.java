import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = getValue(i, j, n);

                if (value == m) {
                    x = i + 1;
                    y = j + 1;
                }

                bw.write(value+" ");
            }

            bw.write("\n");
        }

        bw.write(x + " " + y +"\n");

        bw.flush();   //남아있는 데이터를 모두 출력시킴
        bw.close();   //스트림을 닫음
    }

    public static int getValue(int i, int j, int n) {
        int dx = i > n/2 ? n - i -1 : i;
        int dy = j > n/2 ? n - j -1 : j;

        int maxDepth = n/2;
        int depth = dx > dy ? dy : dx;   // 오름차순, 바깥부터 0
        int revDepth = maxDepth - depth; // 내림차순, 바깥부터 maxDepth

        int value = i+j - depth*2;

        value = i <= j ? value : revDepth * 8 - value;

        if (value != 0) {
            revDepth--;
        }

        int k = revDepth * 2 + 1;

        return value + k * k;
    }
}