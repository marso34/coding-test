import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Point<Integer>[] arr = new Point[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            arr[i] = new Point<>(x, y);
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            arr[i].print();
        }
    }
    
    static class Point<T extends Comparable<T>> implements Comparable<Point<T>> {
        private T x;
        private T y;
        
        Point(T x, T y) {
            this.x = x;
            this.y = y;
        }
        
        public void print() {
            System.out.println(x + " " + y);
        }
        
        @Override
        public int compareTo(Point<T> point) {
            return this.x.equals(point.x) ?
                    this.y.compareTo(point.y) :
                    this.x.compareTo(point.x);
        }
    }
}