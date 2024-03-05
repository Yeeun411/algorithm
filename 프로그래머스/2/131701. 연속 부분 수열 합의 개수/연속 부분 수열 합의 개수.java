import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        int N = elements.length;
        int[] extendedElements = new int[2 * N];
        // 원소를 두 배로 늘린 새로운 배열 생성
        for (int i = 0; i < N; i++) {
            extendedElements[i] = extendedElements[i + N] = elements[i];
        }
        
        HashSet<Integer> sums = new HashSet<>();
        // 모든 가능한 연속 부분 수열의 합을 계산
        for (int start = 0; start < N; start++) { // 부분 수열의 시작점
            int sum = 0;
            for (int length = 1; length <= N; length++) { // 부분 수열의 길이
                sum += extendedElements[start + length - 1];
                sums.add(sum);
            }
        }
        
        // 중복을 제거한 후의 합의 개수 반환
        return sums.size();
    }
}