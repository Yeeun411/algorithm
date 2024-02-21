class Solution {
    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                int y = i;
                int x = yellow / i;
                
                if ((x + 2) * (y + 2) - yellow == brown) {
                    return new int[] {x + 2, y + 2};
                }
            }
        }
        return new int[] {};
    }
}