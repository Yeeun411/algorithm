class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }

        int[] answer = new int[n];
        int quotient = s / n;
        int remainder = s % n;

        // 몫을 기반으로 집합 구성
        for (int i = 0; i < n; i++) {
            answer[i] = quotient;
        }

        // 나머지를 분배하여 곱 최대화
        for (int i = 0; i < remainder; i++) {
            answer[n - 1 - i]++;
        }

        return answer;
    }
}
