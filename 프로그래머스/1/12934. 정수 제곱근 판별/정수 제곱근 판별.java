class Solution {
    public long solution(long n) {
        // n의 제곱근을 구합니다.
        double sqrt = Math.sqrt(n);

        // 제곱근이 정수인지 확인합니다.
        if (sqrt == (long) sqrt) {
            // 정수라면 (x + 1)^2를 계산하여 반환합니다.
            return (long) ((sqrt + 1) * (sqrt + 1));
        } else {
            // 제곱근이 정수가 아니라면 -1을 반환합니다.
            return -1;
        }
    }
}