import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> map = new HashMap<>(); 

        int n = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");

        for (String card : cards) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (String in : input) {
            int t = map.get(in) != null ? map.get(in) : 0;
            
            bw.write(t + " ");
        }
   
        bw.flush();
        bw.close();
    }
}