import java.util.*;

class Solution {
    public int[] solution(int[] progress, int[] speeds){
        int[] answer;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progress.length; i++)
            queue.add(progress[i]);
            System.out.println(queue);
    }
    return answer;
}
/*문제 해결 
1. progress들을 담을 큐를 생성함.
2. ArrayLists 최종적으로 몇개의 기능이 배포되는지를 담을 count 배열을 만들어줌. 
3. queue에 프로세스가 있을때까지 반복문을 돌리게 한다. 
4. index */