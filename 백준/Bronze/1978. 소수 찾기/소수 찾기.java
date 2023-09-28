import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            if (isPrime(num)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;

        // 2로 나누어 떨어지는 짝수는 소수가 아니다 (2 제외)
        if (n % 2 == 0) return false;

        // 2 이외의 수로 나누어 떨어지는지 확인
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
