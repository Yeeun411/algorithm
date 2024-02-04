class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCount = 0;
        int yCount = 0;
        
        for (char c : s.toCharArray()) {
            if(c=='p' || c=='P'){
                pCount++;
            }else if(c=='y' || c=='Y'){
                yCount++;
            }
        }
        if(pCount == yCount){
            return true;
        }
        return false;
    }
}