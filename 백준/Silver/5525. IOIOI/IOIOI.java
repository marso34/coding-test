import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        StringBuilder str = new StringBuilder("IOI");
        for (int i = 1; i < n; i++) {
            str.append("OI");
        }

        int count = 0;

        for (int i = 0; i <= m - str.length(); i++) {
            if (arr[i] != 'I') {
                continue;
            }

            for (int j = 0; j < str.length(); j++) {
                if (arr[i + j] != str.charAt(j)) {
                    break;
                }

                if (j == str.length() - 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}