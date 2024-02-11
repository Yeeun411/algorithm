import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int[] solution(String[] gems) {
        // 보석 종류 파악
        HashSet<String> gemSet = new HashSet<>();
        for (String gem : gems) {
            gemSet.add(gem);
        }
        
        int start = 0; // 시작 포인터
        int end = 0; // 끝 포인터
        int minLength = Integer.MAX_VALUE; // 최소 구간 길이
        int minStart = 0; // 최소 구간 시작 포인터
        Map<String, Integer> gemMap = new HashMap<>(); // 현재 구간 내 보석과 그 개수
        
        while (true) {
            // 모든 종류의 보석을 포함하는 경우, 시작 포인터를 오른쪽으로
            if (gemMap.size() == gemSet.size()) {
                if (end - start < minLength) {
                    minLength = end - start;
                    minStart = start;
                }
                gemMap.put(gems[start], gemMap.get(gems[start]) - 1);
                if (gemMap.get(gems[start]) == 0) {
                    gemMap.remove(gems[start]);
                }
                start++;
            } else if (end == gems.length) { // 배열의 끝에 도달한 경우
                break;
            } else { // 현재 구간 내 보석이 모든 종류를 포함하지 않는 경우, 끝 포인터 오른쪽 이동
                gemMap.put(gems[end], gemMap.getOrDefault(gems[end], 0) + 1);
                end++;
            }
        }
        
        return new int[]{minStart + 1, minStart + minLength};
    }
}

