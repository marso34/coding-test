import java.io.*;
import java.util.*;
import java.lang.Math;

class Main {
    static class CustomInt implements Comparable<CustomInt> {
        int value;
        int absValue;

        public CustomInt(int value) {
            this.value = value;
            this.absValue = Math.abs(value);
        }

        @Override
        public int compareTo(CustomInt c) {
            int result = Integer.compare(this.absValue, c.absValue);
            return result == 0 ? Integer.compare(this.value, c.value) : result;            
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<CustomInt> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                queue.add(new CustomInt(x));
            } else if (queue.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(queue.poll().value);
            }
        }
    }
}