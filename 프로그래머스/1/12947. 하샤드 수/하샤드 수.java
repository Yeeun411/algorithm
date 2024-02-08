class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int n = x;
        int tmp = 0;
        while(x>0){
            tmp += x%10;
            x = (x-x%10)/10;
        }
        if(n%tmp != 0){
            answer = false;
        }
        return answer;
    }
}