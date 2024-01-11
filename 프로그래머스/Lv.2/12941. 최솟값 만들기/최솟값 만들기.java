import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputA = scanner.nextLine();
        int[] arrayA = parseArray(inputA);

        String inputB = scanner.nextLine();
        scanner.close();
        int[] arrayB = parseArray(inputB);

        System.out.println(solution(arrayA, arrayB));
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }

    private static int[] parseArray(String input) {
        input = input.replaceAll("[\\[\\]]", "");
        String[] parts = input.split(",");
        int[] array = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i].trim());
        }
        return array;
    }
}
