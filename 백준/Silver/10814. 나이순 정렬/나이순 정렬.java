import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Member> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            
            list.add(new Member(age, name, i));
        }
        
        Collections.sort(list);
        
        for(Member member : list) {
            member.print();
        }
    }
    
    static class Member implements Comparable<Member> {
        private int age;
        private String name;
        private int createAt;
        
        Member(int age, String name, int createAt) {
            this.age = age;
            this.name = name;
            this.createAt = createAt;
        }
        
        public void print() {
            System.out.println(age + " " + name);
        }
        
        @Override
        public int compareTo(Member other) {
            return this.age == other.age ? Integer.compare(this.createAt, other.createAt) : Integer.compare(this.age, other.age);
        }
    }
}