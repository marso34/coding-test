import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();

        int index = 0;
        int startIdx = 0;
        int endIdx = -1;

        Queue<String> queue = new LinkedList<>();
        LinkedList<Boolean> list = new LinkedList<>();

        for (char ch : input.toCharArray()) {
            if (ch == '<') {
                startIdx = index;
                
                if (startIdx != 0 && startIdx-1 != endIdx) { // 두번째 괄호부터 
                    queue.add(input.substring(endIdx+1, startIdx));
                    list.add(false);
                }
            } else if (ch == '>') {
                endIdx = index;

                queue.add(input.substring(startIdx, endIdx+1));
                list.add(true);
            } else if (index == input.length()-1) {
                queue.add(input.substring(endIdx+1));
                list.add(false);
            }

            index++;
        }
        

        while (queue.size() > 0) {
            if (list.poll()) {
                System.out.print(queue.poll());
            } else {
                StringBuilder sb = new StringBuilder();
                
                String[] arr = queue.poll().split(" ");
                
                for (int i = 0; i < arr.length; i++) {
                    StringBuilder temp = new StringBuilder(arr[i]).reverse();

                    if (i != arr.length-1)
                        temp.append(" ");
                        
                    System.out.print(temp);
                }
                
                System.out.print(sb);
            }
        }
    }
}