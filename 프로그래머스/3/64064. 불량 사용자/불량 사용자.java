import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Solution {
    private Set<Set<String>> uniqueCombinations = new HashSet<>(); // 고유한 조합

    public int solution(String[] user_id, String[] banned_id) {
        backtracking(user_id, banned_id, new HashSet<>(), 0);
        return uniqueCombinations.size();
    }

    private void backtracking(String[] user_id, String[] banned_id, Set<String> currentCombination, int index) {
        if (index == banned_id.length) {
            uniqueCombinations.add(new HashSet<>(currentCombination)); // 고유 조합 세트에 추가
            return;
        }

        String pattern = banned_id[index].replace("*", ".");
        for (String user : user_id) {
            if (Pattern.matches(pattern, user) && !currentCombination.contains(user)) { // 패턴과 일치하며 아직 선택되지 않은 아이디라면
                currentCombination.add(user); // 조합에 추가
                backtracking(user_id, banned_id, currentCombination, index + 1); // 다음 불량 아이디로
                currentCombination.remove(user); // 현재 선택을 취소하고 다시 탐색
            }
        }
    }
}