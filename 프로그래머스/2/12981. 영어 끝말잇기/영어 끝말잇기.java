import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        char lastChar = words[0].charAt(0);
        

        for (int i = 0; i < words.length; i++) {
            if (usedWords.contains(words[i]) || words[i].charAt(0) != lastChar) {
                // (i % n) + 1은 탈락하는 플레이어 번호를, (i / n) + 1은 탈락하는 턴을 계산
                return new int[]{(i % n) + 1, (i / n) + 1};
            }

            usedWords.add(words[i]);  // 현재 단어를 사용된 단어 집합에 추가
            lastChar = words[i].charAt(words[i].length() - 1);  // 마지막 문자 업데이트
        }

        return new int[]{0, 0};
    }
}
