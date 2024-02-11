class Solution {
    public int solution(int[] cookie) {
        int n = cookie.length;
        // 누적 합 계산
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + cookie[i];
        }

        int answer = 0;

        // 중간 지점 m을 기준으로 설정
        for (int m = 0; m < n; m++) {
            int lSum = 0, rSum = 0;
            int l = m, r = m + 1;

            while (l >= 0 && r < n) {
                lSum = prefixSum[m + 1] - prefixSum[l]; // 왼쪽 구간 합
                rSum = prefixSum[r + 1] - prefixSum[m + 1]; // 오른쪽 구간 합

                if (lSum == rSum) { // 두 구간의 합이 같을 때
                    answer = Math.max(answer, lSum); // 최대 과자 수 갱신
                    l--; // 왼쪽으로 확장
                    r++; // 오른쪽으로 확장
                } else if (lSum > rSum) { // 왼쪽 구간 합이 더 클 때, 오른쪽으로 확장
                    r++;
                } else { // 오른쪽 구간 합이 더 클 때, 왼쪽으로 확장
                    l--;
                }
            }
        }

        return answer;
    }
}
