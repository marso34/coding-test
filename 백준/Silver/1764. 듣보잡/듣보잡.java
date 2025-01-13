import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> list = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n + m; i++) {
            String temp = br.readLine();

            if (i < n) { // 듣도 못한 사람
                list.add(temp);
            } else {     // 보도 못한 사람
                if (list.contains(temp)) {
                    result.add(temp);
                }
            }
        }

        result.sort(String::compareTo);

        System.out.println(result.size());
        result.forEach(System.out::println);
    }
}