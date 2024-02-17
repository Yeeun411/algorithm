import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] temp = new int[arr.length];
        int count = 0;
        
        for(int element : arr) {
            if(element % divisor == 0) {
                temp[count++] = element;
            }
        }
        
        if(count == 0) {
            return new int[]{-1};
        }
        
        int[] answer = Arrays.copyOf(temp, count);
        Arrays.sort(answer);
        
        return answer;
    }
}
