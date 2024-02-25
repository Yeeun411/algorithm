import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> prev = new HashSet<>();
        String word = words[0];
        prev.add(word);

        for (int i = 1; i < words.length; i++) {
            if (prev.contains(words[i]) || word.charAt(word.length() - 1) != words[i].charAt(0)) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }

            prev.add(words[i]);
            word = words[i];
        }


        return new int[]{0, 0};
    }
}
