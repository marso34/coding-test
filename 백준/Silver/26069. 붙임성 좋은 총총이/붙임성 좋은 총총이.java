import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        map.put("ChongChong", 1);

        int cnt = 0;
        int enterCnt = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String r1 = st.nextToken();
            String r2 = st.nextToken();


            if (map.get(r1) != null) {
                map.put(r2, 1);
            } else if (map.get(r2) != null) {
                map.put(r1, 1);
            }
        }

        System.out.println(map.size());
    }
}