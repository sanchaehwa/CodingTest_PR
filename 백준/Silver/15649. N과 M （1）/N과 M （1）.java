import java.util.Scanner;

public class Main {
    static int N,M;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 3이라하면 1,2,3 중에서 숫자 선택
        M = sc.nextInt(); // 두개의 숫자 선택해 조합 생성
        visited = new boolean[N+1]; //현재 선택 (false면 선태되지 않은 상태)
        result = new int[M]; //선택한 숫자를 저장

        backtrack(0); //백트레이킹 시작 
        sc.close();

    }
    public static void backtrack(int depth) {
        if (depth == M) { //깊이 확인
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 방문하지 않은 숫자만 선택
                visited[i] = true;
                result[depth] = i;
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
    /* depth = 0
    3 2 
    3 : [true false false false]
    result [1, ?]
    depth = 1
    3 : [false true false false]
    1 2 
    depth = 2
    3 : [false false true false]
    1 3
     * */
}
