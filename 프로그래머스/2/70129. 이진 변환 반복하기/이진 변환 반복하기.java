public class Solution {
    public int[] solution(String s) {
        
        int n = 0;
        int removedZeroCount = 0;

        while (!s.equals("1")) {
            
            int includeZero = s.length();
            s = s.replaceAll("0", "");
            int excludeZero = s.length();
            removedZeroCount += (includeZero - excludeZero);

            s = Integer.toBinaryString(excludeZero);
            n++;
            
        }
        
        return new int[]{n, removedZeroCount};
        
    }
}