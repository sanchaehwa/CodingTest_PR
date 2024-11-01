//N - M 자연수가 주어졌을때, 중복되는 수열을 여러번 출력하면 안되며, 길이가 M인 수열을 모두 구해라
import java.util.*;

public class Main {
    //공통 변수 선언
    static int M;
    static int[] numbers;
    static boolean[] visited; 
    static int[] result;
    //입력(<- 벡트레이킹을 수행하기 위해) 과 출력 (<- 백트레이킹 수행한 결과를)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //입력받을 숫자 길이
        M = sc.nextInt(); //depth
        
        numbers = new int[N];
        for (int i=0; i < N; i++){
            numbers[i] = sc.nextInt();
        }
        //오름차순 정렬 
        Arrays.sort(numbers);
        visited = new boolean[N+1];
        result = new int[M];
        
        backtrack(0);
 
    }
    
    //백트레이킹 수행
    public static void backtrack(int depth) {
        if(depth == M){
            for(int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < numbers.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = numbers[i];
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
}
//backtrack(0)            → depth: 0
//        ├── 선택: 1 → backtrack(1)      → depth: 1
//        │     ├── 선택: 7 → 출력 [1, 7]
//        │     ├── 선택: 8 → 출력 [1, 8]
//        │     └── 선택: 9 → 출력 [1, 9]
//        ├── 선택: 7 → backtrack(1)      → depth: 1
//        │     ├── 선택: 1 → 출력 [7, 1]
//        │     ├── 선택: 8 → 출력 [7, 8]
//        │     └── 선택: 9 → 출력 [7, 9]
//        ├── 선택: 8 → backtrack(1)      → depth: 1
//        │     ├── 선택: 1 → 출력 [8, 1]
//        │     ├── 선택: 7 → 출력 [8, 7]
//        │     └── 선택: 9 → 출력 [8, 9]
//        └── 선택: 9 → backtrack(1)      → depth: 1
    //        ├── 선택: 1 → 출력 [9, 1]
    //        ├── 선택: 7 → 출력 [9, 7]
    //        └── 선택: 8 → 출력 [9, 8]