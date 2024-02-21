import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 인접 리스트
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] connection : edge) {
            adjList.get(connection[0]).add(connection[1]);
            adjList.get(connection[1]).add(connection[0]);
        }

        // BFS
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    distance[neighbor] = distance[current] + 1;
                }
            }
        }

        // 가장 멀리 떨어진 노드의 거리 찾기 및 개수 세기
        int maxDistance = 0;
        int count = 0;
        for (int dist : distance) {
            if (dist > maxDistance) {
                maxDistance = dist;
                count = 1; // 새로운 최대 거리를 찾으면 카운트를 1로 리셋
            } else if (dist == maxDistance) {
                count++; // 같은 최대 거리를 가진 노드 발견시 카운트 증가
            }
        }
        
        return count;
    }
}
