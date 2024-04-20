import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            int t = ttt(a, b);

            System.out.println(t);
        }       
    }

    public static int ttt(int floor, int room) {
        if (floor == 0) {
            return room;
        }

        if (room == 1) {
            return 1;
        }

        return ttt(floor-1, room) + ttt(floor, room-1);
    }
}