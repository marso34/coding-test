import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        } // 여기까지 입력

        long max = 0;
        
        /**
         * i, j는 벌, k는 벌통 (i, j는 순서 상관 X) * i, j 값은 연산에서 제거
         * 
         * i 왼쪽 고정 => j 오른쪽 고정 => k 선택
         * i 왼쪽 고정 => k 오른쪽 고정 => j 선택
         * k 왼쪽 고정 => j 오른쪽 고정 => i 선택
         * 
         */  
        for (int index = 1; index < n-1; index++) {
            long sum = 0;

            // index가 k일 경우
            // 1 ~ k   합
            // k ~ n-1 합
            sum += arr[index]; // k값 중복

            for (int i = 1; i < n-1; i++) {
                sum += arr[i];
            }

            if (sum > max) {
                max = sum;
            }

            // index가 j일 경우
            // 1 ~ n 합-j
            // j+1 ~ n 합
            sum = 0;

            for (int i = 1; i < n; i++) {
                if (i == index) { // j 값 제거
                    continue;
                } else if (i > index) { // j+1 ~ n
                    sum += arr[i];
                }

                sum += arr[i];
            }

            if (sum > max) {
                max = sum;
            }

            // index가 i일 경우
            // 0 ~ i-1 합
            // 0 ~ n-1 합-i
            sum = 0;

            for (int i = 0; i < n-1; i++) {
                if (i == index) { // j 값 제거
                    continue;
                } else if (i < index) { // j+1 ~ n
                    sum += arr[i];
                }

                sum += arr[i];
            }
            
            if (sum > max) {
                max = sum;
            }
        }

        System.out.println(max);
    } 
}