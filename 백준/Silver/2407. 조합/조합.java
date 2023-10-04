import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println(combination(n, m));
    }

    static BigInteger factorial(int start, int end) {
        BigInteger result = BigInteger.ONE;
        for (int i = start; i > end; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    static BigInteger combination(int n, int m) {
        // n! / (m! * (n-m)!)
        // 분자: n!/(n-m)! 과 분모: m!을 각각 계산하여 오버플로우를 방지
        BigInteger numerator = factorial(n, n-m); // 분자
        BigInteger denominator = factorial(m, 1); // 분모

        return numerator.divide(denominator);
    }
}
