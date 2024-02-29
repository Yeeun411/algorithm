import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 사람들의 몸무게를 오름차순으로 정렬
        int answer = 0; // 사용된 구명보트의 수
        int i = 0; // 가장 가벼운 사람의 인덱스
        int j = people.length - 1; // 가장 무거운 사람의 인덱스
        
        while(i <= j) {
            // 가장 무거운 사람과 가장 가벼운 사람의 합이 무게 제한을 초과하면
            // 가장 무거운 사람은 혼자 타야 함
            if (people[j] + people[i] > limit) {
                j--;
            } else {
                // 두 사람이 함께 탈 수 있으면 둘 다 보트에 태움
                i++;
                j--;
            }
            answer++; // 구명보트 수 증가
        }
        
        return answer; // 필요한 구명보트의 최솟값 반환
    }
}