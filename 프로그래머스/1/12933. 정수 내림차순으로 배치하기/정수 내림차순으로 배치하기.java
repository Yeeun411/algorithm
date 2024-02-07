import java.util.Arrays;
class Solution {
    public long solution(long n) {
        String nString = n+"";
        String answer = "";
        char[] charArr = nString.toCharArray();
        Arrays.sort(charArr);
        for(int i=0;i<charArr.length;i++){
            answer += charArr[charArr.length-1-i];
        }
        return Long.parseLong(answer);
    }
}