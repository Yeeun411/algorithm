class Solution {
    public int solution(int n) {
        if (n < 2) {
            return n;
        }

        int a = 0;
        int b = 1;
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            answer = (a + b) % 1234567;
            a = b;
            b = answer;
        }

        return answer;
    }
}