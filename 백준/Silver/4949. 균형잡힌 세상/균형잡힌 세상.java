import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');

        String input;
        
        loop1:
        while (!(input = br.readLine()).equals(".")) {
            Stack<Character> list = new Stack<>();
            
            for (char ch : input.toCharArray()) {
                if (ch == '(' || ch == '[') {
                    list.push(ch);
                } else if (ch == ')' || ch == ']') {
                    if (list.size() > 0 && ch == map.get(list.peek())) {
                        list.pop();
                    } else {
                        System.out.println("no");
                        continue loop1;
                    }
                } 
            }
            
            if (list.size() == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}