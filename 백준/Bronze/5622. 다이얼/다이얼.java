import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int result = 0;

        int[] limits = {3, 3, 3, 3, 3, 4, 3, 4};

        for (char c : input) {
            int num = c - 'A';
            int count = 0;

            for (int i = 0; i < limits.length; i++) {
                if (num < count + limits[i]) {
                    result += i + 3;
                    break;
                }

                count += limits[i];
            }
        }

        System.out.println(result);
    }
}