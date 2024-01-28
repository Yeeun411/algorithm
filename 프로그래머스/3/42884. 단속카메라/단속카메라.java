import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        int answer = 0;
        int camera = Integer.MIN_VALUE;

        for (int[] route : routes) {
            // 현재 카메라 위치가 경로에 포함되지 않는 경우
            if (camera < route[0]) {
                // 새로운 카메라
                camera = route[1];
                answer++;
            }
        }

        return answer;
    }
}