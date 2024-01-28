class Solution {
    public int solution(int n) {
        long answer = 1;

        // Cn = (1/(n+1)) * (2n)! / (n! * n!)
        for (int i = 0; i < n; i++) {
            answer *= 2 * (2 * i + 1);
            answer /= (i + 2);
        }

        return (int)answer;

    }
}