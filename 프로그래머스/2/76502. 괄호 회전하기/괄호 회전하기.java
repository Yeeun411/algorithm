import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isCorrect(s)) {
                answer++;
            }
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }

    private boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char last = stack.peek();
                if ((c == ')' && last == '(') || (c == ']' && last == '[') || (c == '}' && last == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}