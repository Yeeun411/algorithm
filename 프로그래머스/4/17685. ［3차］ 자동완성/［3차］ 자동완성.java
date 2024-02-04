import java.util.Arrays;

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Arrays.sort(words);

        for (int i = 0; i < words.length; i++) {
            int count = 0;

            // 이전 단어와 비교
            if (i > 0) {
                count = Math.max(count, commonRange(words[i], words[i - 1]));
            }
            // 다음 단어와 비교
            if (i < words.length - 1) {
                count = Math.max(count, commonRange(words[i], words[i + 1]));
            }

            // commonRange의 결과가 words[i]의 길이와 같으면 count만 더함
            if (count == words[i].length()) {
                answer += count;
            } else {
                answer += count + 1;
            }
        }

        return answer;
    }

    // 공통 앞부분 찾기
    private int commonRange(String a, String b) {
        int minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return i;
            }
        }
        return minLength;
    }
}
