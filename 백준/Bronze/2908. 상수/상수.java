import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String strA = st.nextToken();
        String strB = st.nextToken();

        int revA = 0;
        int revB = 0;
        int c = 100;

        for (int i = 2; i >= 0; i--) {
            revA += (strA.charAt(i) - '0') * c;
            revB += (strB.charAt(i) - '0') * c;
            c /= 10;
        }

        System.out.println(revA > revB ? revA : revB);
    }
}