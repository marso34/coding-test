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

        // i, j 벌 위치 
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                // 벌통 장소
                for (int k = 0; k < n; k++) { 
                    if (i == k || j == k) {
                        continue;
                    }
                    
                    // 모든 인덱스를 활용하지 않을 경우
                    if (!(i == 0 && k == n-1) && !(k == 0 && j == n-1) && !(i == 0 && j == n-1)) {
                        continue;
                    }
                    
                    /**
                     * 꿀 양 계산
                     * 
                     * i ~ k까지 꿀 + j ~ k까지 꿀 
                     */
                    int index1 = i; 
                    int index2 = j;
                    
                    long sum = 2* arr[k] - arr[i] - arr[j]; // 2 * 도착지점 - (두 출발 지점)

                    // 출발지점부터 도착지점 이전 까지 sum
                    // 원래 목표: 출발지 제외 도착지점까지 sum
                    while (index1 != k || index2 != k) {
                        if (index1 != k) {
                            if (index1 != j) {
                                sum += arr[index1];
                            }
                            
                            index1 = (i > k) ? index1-1 : index1+1;
                        }

                        if (index2 != k) {
                            if (index2 != i) {
                                sum += arr[index2];
                            }
                            
                            index2 = (j > k) ? index2-1 : index2+1;
                        }
                    }
                    
                    if (sum > max) {
                        max = sum;
                    } 
                }
            }
        }
        
        System.out.println(max);
    } 
}