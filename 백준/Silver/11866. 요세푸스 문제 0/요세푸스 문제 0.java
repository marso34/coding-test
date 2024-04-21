import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;

        ArrayList<Integer> list = IntStream.range(1, n+1)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        int index = k;

        while (list.size() > 0) {
            while (index >= list.size()) {
                index -= list.size();
            }

            answer.add(list.get(index));
            list.remove(index);

            index += k;
        }
        
        // 출력 형식 맞추기기
        String output = answer.stream()
                .map(String::valueOf) 
                .reduce((s1, s2) -> s1 + ", " + s2) 
                .map(result -> "<" + result + ">") 
                .orElse("");
        
        System.out.println(output);
    }
}