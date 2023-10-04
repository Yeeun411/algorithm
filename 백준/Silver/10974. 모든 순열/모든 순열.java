import java.util.Scanner;

public class Main {

    static int[] array;
    static boolean[] visited;
    static int[] output;
    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        array = new int[N];
        visited = new boolean[N];
        output = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = i + 1;
        }

        generatePermutation(0);

        scanner.close();
    }

    static void generatePermutation(int depth) {
        // 재귀의 깊이가 N에 도달하면, 만들어진 순열을 출력하고 리턴
        if (depth == N) {
            for (int value : output) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        // 아직 방문하지 않은 노드를 방문하면서 순열 생성
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = array[i];
                generatePermutation(depth + 1);

                visited[i] = false;
            }
        }
    }
}
