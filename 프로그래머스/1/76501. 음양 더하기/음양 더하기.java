class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int length = absolutes.length;
        int answer = 0;
        for(int i = 0;i<length;i++){
            if(signs[i]!=true){
                absolutes[i] *= -1;
            }
            answer += absolutes[i];
            
        }
    
        return answer;
    }
}