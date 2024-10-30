import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] result; //조합 결과를 저장할 배열
    static StringBuilder sb = new StringBuilder(); // 결과를 한 번에 저장할 StringBuilder

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // N과 M 값을 입력받는다
        N = sc.nextInt();
        M = sc.nextInt();

        result = new int[M]; 
        backtrack(0); //backtracking start
        
        System.out.print(sb.toString()); // 모든 결과를 한 번에 출력
        
    }

    public static void backtrack(int depth) {
        if (depth == M) { //depth == M 조합 완성 
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" "); 
            }
            sb.append("\n"); 
            return; //현재 조합 완성 return
        }

        for (int i = 1; i <= N; i++) { //1부터 N 까지의 숫자 선택
            result[depth] = i; //현재의 depth 위치(2 -> move -> 3 -> move -> 4)
            backtrack(depth + 1); //다음깊이로 이동해서 다음 숫자를 선택
        }
    }
}
//선택된 숫자를 저장하는 visted 배열을 지우고, false면 선택되지않은수, 즉 방문한 숫자도 고르게 하니깐 
//조건에 부합한 같은수를 여러번 고를 수 있다. 