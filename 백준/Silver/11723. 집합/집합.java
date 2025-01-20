import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int idx = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) - 1 : -1;

            switch (cmd) {
                case "add":
                    k |= (1 << idx);
                    break;
                case "remove":
                    k &= ~(1 << idx);
                    break;
                case "check":
                    bw.write((k & (1 << idx)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    k ^= (1 << idx);
                    break;
                case "all":
                    k = 1048575;
                    break;
                case "empty":
                    k = 0;
                    break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
