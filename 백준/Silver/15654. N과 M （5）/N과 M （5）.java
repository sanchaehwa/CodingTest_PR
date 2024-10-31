import java.util.*;

public class Main {
    static int M;
    static int[] numbers;
    static boolean[] visited;
    static int[] result; // 현재 선택된 숫자 저장
    //static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 4
        M = sc.nextInt(); //2

        numbers = new int[N]; // 사용할 숫자를 입력받음(4개의 숫자를 입력받고)
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt(); // 0 ~ 3까지 숫자를 입력
        }
        Arrays.sort(numbers); // 입력된 숫자를 오름차순 정렬
        visited = new boolean[N+1];
        result = new int[M];

        backtrack(0);
       // System.out.println(sb.toString());
    }

    public static void backtrack( int depth) {
        if (depth == M) { // 깊이가 M일 때 결과 저장
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            } //현재문자열 끝에 문자열 추가
            System.out.println();
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
           if (!visited[i]) { //방문하지않은 조건
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