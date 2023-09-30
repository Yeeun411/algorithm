import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 에라토스테네스의 체
        final int MAX = 2 * 1000000;
        boolean[] isPrime = new boolean[MAX+1];
        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i*i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= MAX; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            
            int count = 0;
            for (int i = n+1; i <= 2*n; i++) {
                if (isPrime[i]) count++;
            }
            
            System.out.println(count);
        }
    }
}

