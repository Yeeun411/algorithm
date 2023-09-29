import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            if (M == 0 && N == 0)
                break;
            if(M < N && N % M == 0)
                System.out.println("factor");
            else if(M > N && M % N == 0)
                System.out.println("multiple");
            else
                System.out.println("neither");
        }
        scanner.close(); 
    }
}