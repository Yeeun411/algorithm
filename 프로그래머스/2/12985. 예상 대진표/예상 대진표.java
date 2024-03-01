class Solution {
    public int solution(int N, int A, int B) {
        int round = 0;
        
        while(A != B) {
            A = A / 2 + A % 2; // A번 참가자의 다음 라운드 번호
            B = B / 2 + B % 2; // B번 참가자의 다음 라운드 번호
            round++; // 라운드 수 증가
        }
        
        return round;
    }
}
