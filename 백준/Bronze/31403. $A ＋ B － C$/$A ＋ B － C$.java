import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strA = br.readLine();
        String strB = br.readLine();
        String strC = br.readLine();

        int A = Integer.parseInt(strA);
        int B = Integer.parseInt(strB);
        int C = Integer.parseInt(strC);

        System.out.println(A + B - C);
        System.out.println(Integer.parseInt(strA + strB) - C);
    }
}