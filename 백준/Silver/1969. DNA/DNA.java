import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] dna = new char[n][];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            dna[i] = input.toCharArray();
        }

        String map = "ACGT";
        char[] answer = new char[m];
        int sum = 0;

        for (int i = 0; i < m; i++) {
            int[] nucleotide = new int[4];
            int max = 0;
            int maxIndex = 0;

            for (int j = 0; j < n; j++) {
                nucleotide[map.indexOf(dna[j][i])]++;
            }

            for (int j = 0; j < 4; j++) {
                if (nucleotide[j] > max) {
                    max = nucleotide[j];
                    maxIndex = j;
                }
            }

            sum += (n - max);
            answer[i] = map.charAt(maxIndex);
        }

        System.out.println(new String(answer));
        System.out.println(sum);
    }
}