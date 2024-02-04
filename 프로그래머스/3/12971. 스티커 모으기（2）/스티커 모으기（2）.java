class Solution {
    public int solution(int[] sticker) {
        if (sticker.length == 1) {
            return sticker[0];
        }

        // 배열에서 첫 번째 스티커를 선택하는 경우
        int includeFirst = findMaxTotal(sticker, 0, sticker.length - 2);
        // 첫 번째 스티커를 선택하지 않는 경우
        int excludeFirst = findMaxTotal(sticker, 1, sticker.length - 1);

        return Math.max(includeFirst, excludeFirst);
    }

    private int findMaxTotal(int[] sticker, int start, int end) {
        if (start == end) {
            return sticker[start];
        }

        int[] dp = new int[sticker.length];
        dp[start] = sticker[start];
        dp[start + 1] = Math.max(sticker[start], sticker[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }

        return dp[end];
    }
}