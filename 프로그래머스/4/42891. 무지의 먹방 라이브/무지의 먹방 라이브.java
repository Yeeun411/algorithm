import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        long total = 0; // 모든 음식을 먹는데 필요한 총 시간
        for (int time : food_times) {
            total += time;
        }

        if (total <= k) return -1; // 모든 음식을 먹기 전에 방송이 중단된 경우

        PriorityQueue<Food> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(i + 1, food_times[i]));
        }

        total = 0; // 지금까지 먹은 시간
        long previous = 0; // 이전에 먹은 음식 시간
        long size = food_times.length; // 남은 음식의 개수

        while (total + ((pq.peek().time - previous) * size) <= k) {
            int now = pq.poll().time;
            total += (now - previous) * size;
            size -= 1; 
            previous = now;
        }

        List<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        result.sort((a, b) -> a.index - b.index);
        return result.get((int)((k - total) % size)).index;
    }

    class Food {
        int index;
        int time;

        Food(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}
