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
         * 
         * 배열의 누접합으로로 계산
         * 
         * i 왼쪽 고정 => j 오른쪽 고정 => k 선택
         * i 왼쪽 고정 => k 오른쪽 고정 => j 선택
         * k 왼쪽 고정 => j 오른쪽 고정 => i 선택
         * 
         */
        long[] left = new long[n];
        long[] right = new long[n];

        left[0] = arr[0];       // 오름차순 
        right[n-1] = arr[n-1];  // 내림차순 

        for (int i = 1; i < n; i++) {
            left[i] = left[i-1] + arr[i];
            right[n-i-1] = right[n-i] + arr[n-i-1];
        }

        for (int index = 1; index < n-1; index++) {
            // index가 k일 경우
            // 1 ~ k   합
            // n-1 ~ k 합
            long sum1 = left[index] - arr[0] + right[index] - arr[n-1];

            // index가 j일 경우
            // 1 ~ n 합-j
            // j+1 ~ n 합
            long sum2 = left[n-1] - arr[0] - arr[index] + left[n-1] - left[index];         

            // index가 i일 경우
            // i-1 ~ 0 합
            // n-2 ~ 0 합-i
            long sum3 = right[0] - right[index] + right[0] - arr[n-1] - arr[index];

            if (sum1 > max) 
                max = sum1;

            if (sum2 > max)
                max = sum2;
            
            if (sum3 > max)
                max = sum3;
        }

        System.out.println(max);
    } 
}