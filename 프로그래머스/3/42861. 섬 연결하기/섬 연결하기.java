import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] costs) {
        // 다리 비용 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        
        // 각 섬의 최상위 부모 초기화
        int[] parentIsland = new int[n];
        for (int i = 0; i < n; i++) {
            parentIsland[i] = i;
        }
        
        int totalCost = 0;
        for (int[] cost : costs) {
            int islandA = find(parentIsland, cost[0]);
            int islandB = find(parentIsland, cost[1]);
            
            // 사이클이 형성되지 않는 경우, 간선 추가
            if (islandA != islandB) {
                totalCost += cost[2];
                union(parentIsland, islandA, islandB); // 두 섬을 연결
            }
        }
        
        return totalCost;
    }
    
    // 최상위 부모 찾기
    private int find(int[] parentIsland, int island) {
        if (island == parentIsland[island]) {
            return island;
        }
        return parentIsland[island] = find(parentIsland, parentIsland[island]);
    }
    
    // 두 섬 연결
    private void union(int[] parentIsland, int islandA, int islandB) {
        int rootA = find(parentIsland, islandA);
        int rootB = find(parentIsland, islandB);
        // 두 섬의 최상위 부모가 다를 경우 통합
        if (rootA != rootB) {
            parentIsland[rootA] = rootB;
        }
    }
}
