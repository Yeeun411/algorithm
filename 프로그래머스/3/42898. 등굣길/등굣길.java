class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // dp[i][j]는 (i, j)까지 도달하는 경로의 수
        int[][] dp = new int[m + 1][n + 1];

        // (1, 1)은 경로가 하나뿐
        dp[1][1] = 1;

        // -1은 경로가 없음 의미
        for (int[] puddle : puddles) {
            dp[puddle[0]][puddle[1]] = -1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 물 위치는 계산에서 제외
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                }else{
                // 현재 위치에 오는 방법: 위에서 아래, 왼에서 오 이동.
                // 위에서 아래
                if (i > 1) dp[i][j] += dp[i - 1][j] % 1000000007;
                // 왼쪽에서 오
                if (j > 1) dp[i][j] += dp[i][j - 1] % 1000000007;
                }
            }
        }

        return dp[m][n] % 1000000007;
    }
}


