import java.io.*;
import java.util.HashMap;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        int cnt = 0;
        int enterCnt = 0;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.equals("ENTER")) {
                enterCnt++;
            } else {
                if (map.getOrDefault(input, 0) < enterCnt) {
                    cnt++;
                }

                map.put(input, enterCnt);
            }
        }

        System.out.println(cnt);
    }
}