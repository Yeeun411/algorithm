class Solution {
    public int solution(int[] arr) {
        if (arr.length == 1) return arr[0];
        
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = findLCM(lcm, arr[i]);
        }
        
        return lcm;
    }
    
    // 최대공약수(GCD)를 찾는 메서드
    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // 최소공배수(LCM)를 구하는 메서드
    private int findLCM(int a, int b) {
        return a * (b / findGCD(a, b));
    }
}
