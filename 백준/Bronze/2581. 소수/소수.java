import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        int total = 0;
        int min = N;

        for (int i = M; i < N + 1; i++) {
            if (isPrime(i)) {
                total += i;
                if (i < min) {
                    min = i;
                }
            }
        }
        
        if (total != 0) {
            System.out.println(total);
            System.out.println(min);
        } else {
            System.out.println("-1");
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;

        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
