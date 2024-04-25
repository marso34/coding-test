import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        } // 입력

        List<String> list = new ArrayList<>(set);


        list.sort(
            Comparator.comparing(String::length)
                .thenComparing(String::compareTo)
        );

        for (String str : list) {
            System.out.println(str);
        }
    }
}