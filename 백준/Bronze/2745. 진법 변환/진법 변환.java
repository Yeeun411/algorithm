import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();
        int B = scanner.nextInt();
        
        System.out.println(Integer.parseInt(N, B));
        
        scanner.close();
    }
}