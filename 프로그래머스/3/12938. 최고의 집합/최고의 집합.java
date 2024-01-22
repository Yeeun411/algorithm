class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }

        int[] result = new int[n];
        int quotient = s / n;
        int remainder = s % n;

        // 몫의 value를 균등하게 n개만큼 넣음
        for (int i = 0; i < n; i++) {
            result[i] = quotient;
        }

        int j = n-1;
        // 나머지를 뒤에서부터 1씩 분배
        while(remainder > 0) {
        	result[j] += 1;
        	remainder -= 1;
        	j -= 1;
        	
        }
       
        return result;
    }
}
