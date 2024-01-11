import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> workQueue = new PriorityQueue<>((x, y) -> y - x);

        for (int work : works) {
            workQueue.add(work);
        }

        while (n > 0 && !workQueue.isEmpty()) {
            int maxWork = workQueue.poll();
            if (maxWork > 0) {
                workQueue.add(maxWork - 1);
                n--;
            }
        }

        while (!workQueue.isEmpty()) {
            int work = workQueue.poll();
            answer += (long) work * work;
        }

        return answer;
    }
}
