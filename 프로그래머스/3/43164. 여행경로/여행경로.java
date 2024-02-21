import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        /*
        제한사항 '만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.'' 때문에 정렬 필요
        */
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        List<String> answer = new ArrayList<>();
        boolean[] isVisited = new boolean[tickets.length];
        dfs("ICN", "ICN", tickets, isVisited, 0, answer);
        
        return answer.get(0).split(",");
    }
    
    private void dfs(String now, String path, String[][] tickets, boolean[] isVisited, int count, List<String> answer) {
        if (count == tickets.length) {
            answer.add(path);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!isVisited[i] && tickets[i][0].equals(now)) {
                isVisited[i] = true;
                dfs(tickets[i][1], path + "," + tickets[i][1], tickets, isVisited, count + 1, answer);
                isVisited[i] = false;
            }
        }
    }
}
