import java.util.Scanner;

public class Solution {
    public static String solution(String s) {
        String[] numbers = s.split(" ");
        int min = Integer.parseInt(numbers[0]);
        int max = Integer.parseInt(numbers[0]);

        for(String num : numbers) {
            int value = Integer.parseInt(num);
            if(value < min) {
                min = value;
            }
            if(value > max) {
                max = value;
            }
        }

        return min + " " + max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(solution(input));
        scanner.close();
    }
}
