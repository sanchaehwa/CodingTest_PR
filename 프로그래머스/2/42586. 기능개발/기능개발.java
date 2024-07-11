import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i < progresses.length; i++) {
            int days = (int)Math.ceil((100.0 - progresses[i]) / speeds[i] ); // 각 작업이 완료되는 일수를 계산하여 큐에 추가 (반올림)
            queue.add(days);
        } //queue 로 작업완료일수 저장
        while(!queue.isEmpty()) {
            int day = queue.poll();
            //첫번째 작업의 완료 일수를 가져옴
            int count = 1;
            
            while (!queue.isEmpty() && queue.peek() <= day) {
                queue.poll();
                count++;
            }
            result.add(count);
        }
        int [] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
//두번째 기능이 먼저 개발되었다면, 첫번째 기능이 개발된 이후에 함께 배포
