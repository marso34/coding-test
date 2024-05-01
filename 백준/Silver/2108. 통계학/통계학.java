import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        } // 입력

        // 정렬
        Arrays.sort(arr);

        long avg = Math.round(((double) IntStream.of(arr).sum()) / n); // 배열을 모두 더하고 반올림
        int mid = arr[n/2]; // (정렬되어 있는) 배열의 중앙값
        int range = Math.abs(arr[0] - arr[n-1]); // (정렬되어 있는) 배열의 범위 절댓값

        int modeValue = 0;
        int mode = 0;

        ArrayList<Integer> list = new ArrayList<>();
        
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > modeValue) {
                modeValue = entry.getValue();
                mode = entry.getKey();

                list = new ArrayList<>(Arrays.asList(mode));
            } else if (entry.getValue() == modeValue) {
                list.add(entry.getKey());
            }
        }

        if (list.size() > 1) {
            Collections.sort(list);
            mode = list.get(1);
        }

        System.out.println(avg);
        System.out.println(mid);
        System.out.println(mode);
        System.out.println(range);
    }
}