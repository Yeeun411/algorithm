import java.util.Scanner;

public class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];

        dp[0][0] = triangle[0][0];

        // 위에서 아래로 가며 최대합 계산
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0]; // 왼
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i]; // 오

            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, dp[n - 1][i]);
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int[][] triangle = parseTriangle(input);

        Solution solution = new Solution();
        int result = solution.solution(triangle);
        System.out.println("경로의 최대합: " + result);
    }

    private static int[][] parseTriangle(String input) {
        input = input.replaceAll("\\[", "").replaceAll("\\]", "");
        String[] rows = input.split(", ");
        int[][] triangle = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] numbers = rows[i].split(", ");
            triangle[i] = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                triangle[i][j] = Integer.parseInt(numbers[j].trim());
            }
        }
        return triangle;
    }
}
