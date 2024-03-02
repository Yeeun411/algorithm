class Solution {
    public long solution(int n) {
        // n이 1 또는 2인 경우는 바로 결과를 리턴할 수 있습니다.
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        // 피보나치 수열을 계산하기 위한 초기값 설정
        long first = 1; // F(1)
        long second = 2; // F(2)
        long answer = 0; // F(n)을 저장할 변수
        
        // 3부터 n까지의 피보나치 수를 계산
        for (int i = 3; i <= n; i++) {
            answer = (first + second) % 1234567;
            first = second;
            second = answer;
        }
        
        return answer;
    }
}

