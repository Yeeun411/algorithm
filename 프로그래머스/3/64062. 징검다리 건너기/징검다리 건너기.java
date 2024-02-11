class Solution {
    public int solution(int[] stones, int k) {
        int left = 1; // 가능한 최소 인원 수
        int right = 0; // 가능한 최대 인원 수
        for (int stone : stones) {
            right = Math.max(right, stone); // stones 배열의 최대값을 최대 인원 수로 설정
        }
        
        int answer = left; // 답을 저장할 변수, 최소 1명은 건널 수 있음
        while (left <= right) {
            int mid = (left + right) / 2; // 중간값으로 건널 수 있는지 확인
            if (canCross(stones, k, mid)) { // mid 명이 건널 수 있다면
                answer = mid; // 답 업데이트
                left = mid + 1; // 더 많은 인원도 건널 수 있는지 탐색을 계속
            } else { // 건널 수 없다면
                right = mid - 1; // 다시 탐색
            }
        }
        
        return answer;
    }
    
    // mid 명이 건널 수 있는지 없는지를 확인하는 메서드
    private boolean canCross(int[] stones, int k, int mid) {
        int zeroCount = 0; // 연속된 0이 되는 디딤돌의 개수
        for (int stone : stones) {
            if (stone - mid < 0) { // mid 명이 지나면 0 이하가 되는 디딤돌
                zeroCount++;
                if (zeroCount >= k) return false; // 연속된 k개가 되면 건널 수 없음
            } else {
                zeroCount = 0; // 0 이하가 아니면 카운트 리셋
            }
        }
        return true; // 모든 검사를 통과하면 건널 수 있음
    }
}
