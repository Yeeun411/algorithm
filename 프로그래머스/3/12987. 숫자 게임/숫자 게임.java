import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int teamAOrder = 0; // A팀 오름차순 순서
        int point = 0;  // B팀 승점

        for (int teamBOrder = 0; teamBOrder < B.length; teamBOrder++) {
            if (B[teamBOrder] > A[teamAOrder]) { 
                point++;
                teamAOrder++;
            }
        }

        return point;
    }
}