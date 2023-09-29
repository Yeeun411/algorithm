import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int B = scanner.nextInt();
        System.out.println(convertToBaseB(N, B));
        scanner.close();
    }

    public static String convertToBaseB(int num, int base) {
        StringBuilder result = new StringBuilder();

        while (num > 0) {
            int remainder = num % base;

            if (remainder < 10) {
                result.append(remainder);
            } else {
                char ch = (char) ('A' + (remainder - 10));  // 10->A, 11->B, ...
                result.append(ch);
            }

            num /= base;
        }

        return result.reverse().toString();
    }
}
