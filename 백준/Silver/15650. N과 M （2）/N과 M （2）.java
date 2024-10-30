import java.util.Scanner;
public class Main {
    public static int[] result;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        result = new int[M];
        backtrack(1, 0);
        System.out.println(sb.toString());
    }
    public static void backtrack(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = start; i <= N; i++) {
            result[depth] = i;
            backtrack(i + 1, depth + 1); //오름차순 정렬을 탐색하기위해 (1 --+1 --> 2)
        }
    }
}