import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        List<int[]> list = new ArrayList<>();

        int totalCnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // arr[i][j]가 1이면 list에 i, j를 추가
                if (arr[i][j] == 1) {
                    list.add(new int[] {i, j});
                } else if (arr[i][j] == -1) {
                    totalCnt++;
                }
            }
        }

        int cnt = 0;

        while (true) {
            List<int[]> tempList = new ArrayList<>();
            totalCnt += list.size();

            for (int[] a : list) {
                int x = a[0];
                int y = a[1];

                // 상하좌우를 확인하여 0인 경우 1로 바꿔주고 list에 추가
                if (x - 1 >= 0 && arr[x - 1][y] == 0) {
                    arr[x - 1][y] = 1;
                    tempList.add(new int[] {x - 1, y});
                }
                if (x + 1 < n && arr[x + 1][y] == 0) {
                    arr[x + 1][y] = 1;
                    tempList.add(new int[] {x + 1, y});
                }
                if (y - 1 >= 0 && arr[x][y - 1] == 0) {
                    arr[x][y - 1] = 1;
                    tempList.add(new int[] {x, y - 1});
                }
                if (y + 1 < m && arr[x][y + 1] == 0) {
                    arr[x][y + 1] = 1;
                    tempList.add(new int[] {x, y + 1});
                }
            }

            // tempList가 비어있다면 더 이상 익을 수 있는 토마토가 없다는 뜻이므로 break
            if (tempList.isEmpty()) {
                break;
            }

            list = tempList;
            cnt++;
        }

        System.out.println(totalCnt == m *n ? cnt : -1);
    }
}