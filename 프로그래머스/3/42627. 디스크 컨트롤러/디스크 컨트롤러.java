import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // 요청 시간에 따라 jobs 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 소요 시간이 짧은 작업 우선 처리

        int count = 0; // 처리된 작업 수
        int idx = 0; // jobs 배열의 인덱스
        int time = 0; // 현재 시간
        int totalWaitTime = 0; // 총 대기 시간

        while (count < jobs.length) {
            // 현재 시간 이전에 요청된 모든 작업을 우선순위 큐에 추가
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }
            
            if (pq.isEmpty()) {
                // 현재 처리할 수 있는 작업이 없다면, 다음 작업 요청 시간으로 시간을 갱신
                time = jobs[idx][0];
            } else {
                // 처리할 작업이 있다면, 작업 처리
                int[] job = pq.poll();
                time += job[1]; // 현재 시간 업데이트
                totalWaitTime += time - job[0]; // 총 대기 시간 업데이트
                count++; // 처리된 작업 수 업데이트
            }
        }

        return totalWaitTime / jobs.length; // 평균 대기 시간 계산
    }
}