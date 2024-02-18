class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1}; // 배열의 길이가 1인 경우
        
        int min = arr[0]; // 가장 작은 수를 찾기 위한 초기값 설정
        for (int element : arr) {
            if (element < min) {
                min = element; // 더 작은 수를 찾으면 min 업데이트
            }
        }
        
        // 가장 작은 수를 제외한 배열 생성
        int[] answer = new int[arr.length - 1];
        int index = 0;
        for (int element : arr) {
            if (element != min) {
                answer[index++] = element; // min과 다른 원소만 새 배열에 추가
            }
        }
        
        return answer;
    }
}
