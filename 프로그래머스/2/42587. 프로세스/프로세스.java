import java.util.*;

class Solution {
    public int solution(int[] priorities, int location){
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i < priorities.length; i++) {
            queue.add(new int[] {priorities[i], i});
            /*
            (Example)
              priorities : 2 1 3 2
              i (0 ~ 3)
              queue.add  (매핑)
             [ (2,0) (1,1) (3,2) (2,3) ]
            */
        }
        //우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int priority : priorities) {
            pq.add(priority);
                   //우선순위부터 실행을 해야하는 문제 
                   //FIFO (선입선출) 앞에서부터 처리를 해야해서 우선순위가 높은거부터 배열 
        }
        //PriorityQueue<Integer> pq = new PriorityQueue<>(); 우선순위 정렬(오름) // 3 1 2 ->  1 2 3
        int answer = 0;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            //(2,0)
            if (current[0] == pq.peek()) {
                pq.poll();
                answer++; //2번 
                if(current[1] == location){
                    return answer;
                }
            }else {
                queue.add(current);
            }
            
        }
        return answer;
    }
}