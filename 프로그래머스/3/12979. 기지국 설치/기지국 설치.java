class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;
        int idx = 0;

        while (position <= n) {

            if (idx < stations.length && position >= stations[idx] - w) {
                position = stations[idx] + w + 1;
                idx++;
            } else {
                answer++;
                position += (2 * w + 1);
            }
        }

        return answer;
    }
}