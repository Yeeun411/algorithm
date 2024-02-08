import java.util.ArrayList;
public class Solution {
    public int solution(String s) {

        ArrayList<Character> stack = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            // 스택이 비어있지 않고, 현재 문자가 스택의 마지막 문자와 같은 경우
            if (!stack.isEmpty() && stack.get(stack.size() - 1) == currentChar) {
                stack.remove(stack.size() - 1);
            } else {
                // 그렇지 않으면 스택에 현재 문자 추가
                stack.add(currentChar);
            }
        }

        // 스택이 비어있다면 모든 문자가 짝지어 제거된 것이므로 1 반환, 그렇지 않으면 0 반환
        return stack.isEmpty() ? 1 : 0;
    }
}
