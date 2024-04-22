import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        LocalDate localDate = LocalDate.of(a, 1, 1);

        if (localDate.isLeapYear())
            System.out.println(1);
        else 
            System.out.println(0);
    }
}