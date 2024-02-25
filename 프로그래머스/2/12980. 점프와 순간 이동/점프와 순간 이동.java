import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while (n > 0) {
            // 순간이동을 사용할 수 있는 경우 (거리가 2로 나누어떨어지는 경우)
            if (n % 2 == 0) {
                n /= 2;
            } else {
                // 점프를 해야하는 경우 (거리가 2로 나누어떨어지지 않는 경우)
                // 점프로 1칸 이동하므로 건전지 사용량 1 증가
                n -= 1;
                answer += 1;
            }
        }
        
        return answer;
    }
}