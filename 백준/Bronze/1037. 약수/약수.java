import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int[] divisors = new int[count];

        for (int i = 0; i < count; i++) {
            divisors[i] = scanner.nextInt();
        }

        Arrays.sort(divisors);

        int smallestDivisor = divisors[0];
        int largestDivisor = divisors[count - 1];

        System.out.println(smallestDivisor * largestDivisor);
    }
}
