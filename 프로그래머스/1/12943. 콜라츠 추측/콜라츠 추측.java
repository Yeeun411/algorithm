class Solution {
    public int solution(int num) {
        long n = num; // 연산 중 오버플로우를 방지하기 위해 long 타입 사용
        for (int i = 0; i < 500; i++) {
            if (n == 1) return i; // 수가 1이 되면 반복 횟수 반환
            if (n % 2 == 0) {
                n /= 2; // 짝수인 경우 2로 나눔
            } else {
                n = n * 3 + 1; // 홀수인 경우 3을 곱하고 1을 더함
            }
        }
        return -1; // 500번 반복해도 1이 되지 않는 경우 -1 반환
    }
}