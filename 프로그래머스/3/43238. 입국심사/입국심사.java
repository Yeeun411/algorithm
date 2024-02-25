import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = (long)times[0]; // 최소 시간
        long right = (long)times[times.length - 1] * n; // 최대 시간
        long answer = right; // 최대 시간으로 초기 설정

        while (left <= right) {
            long mid = (left + right) / 2; // 중간값
            long count = 0; // mid 시간 동안 심사할 수 있는 인원 수

            //mid 시간 동안 심사 가능한 인원 수 계산
            for (int time : times) {
                count += mid / time;
                if (count >= n) break; // 모든 인원을 심사할 수 있으면 break
            }

            if (count < n) { // 모든 인원을 심사할 수 없는 경우
                left = mid + 1; // 시간 범위를 늘리기
            } else { // 모든 인원을 심사할 수 있는 경우
                right = mid - 1; // 시간 범위를 줄이기
                answer = mid; //answer 갱신
            }
        }

        return answer; // 최소 심사 시간 반환
    }
}
