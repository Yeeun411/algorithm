class Solution {
    public int solution(int n) {
        int countOneOfN = countOnesInBinary(n);
        int answer = n + 1;

        while (countOnesInBinary(answer) != countOneOfN) {
            answer++;
        }

        return answer;
    }

    private int countOnesInBinary(int answer) {
        return Integer.bitCount(answer);
    }
}