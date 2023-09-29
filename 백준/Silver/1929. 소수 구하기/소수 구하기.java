import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        
        boolean[] isPrime = new boolean[N+1];
        
        // 모든 숫자를 소수로 초기화
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }
        
        // 에라토스테네스의 체
        for (int i = 2; i*i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= N; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        // M 이상 N 이하의 소수 출력
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
        scanner.close();
    }
}
