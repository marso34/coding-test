import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[3];

        for (int i = 0; i < 3; i++) {
            String str = br.readLine();

            switch (str) {
                case "Fizz":
                case "Buzz":
                case "FizzBuzz":
                    input[i] = 0;
                    break;
                default:
                    input[i] = Integer.parseInt(str);
                    break;
            }
        }

        int result = 0;

        for (int i = 0; i < 3; i++) {
            if (input[i] != 0) {
                result = input[i] + (3 - i);
                break;
            }
        }

        if (result % 3 == 0 && result % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (result % 3 == 0) {
            System.out.println("Fizz");
        } else if (result % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(result);
        }
    }
}