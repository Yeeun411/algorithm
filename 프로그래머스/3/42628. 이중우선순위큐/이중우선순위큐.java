import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            switch (command) {
                case "I":
                    minHeap.add(number);
                    maxHeap.add(number);
                    break;
                case "D":
                    if (!minHeap.isEmpty()) {
                        if (number == 1) {
                            int max = maxHeap.poll();
                            minHeap.remove(max);
                        } else {
                            int min = minHeap.poll();
                            maxHeap.remove(min);
                        }
                    }
                    break;
            }
        }

        if (minHeap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxHeap.peek(), minHeap.peek()};
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replaceAll("[\\[\\]\"]", "");
        String[] operations = input.split(", ");

        Solution solution = new Solution();
        int[] result = solution.solution(operations);
        System.out.println(Arrays.toString(result));
    }
}