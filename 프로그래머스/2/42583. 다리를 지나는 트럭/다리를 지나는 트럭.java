import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    Queue<Integer> bridge = new LinkedList<>();
        for (int i=0; i<bridge_length; i++){
            bridge.offer(0); //birdge_length만큼의 크기를 갖는 큐생성, 초깃값으로 0을 채워줌
        }
        //다리에 트럭이 최대 올라갈 수 있는 수가 1(kg) // 한번에 하나의 트럭만 건널수 있음.
        //특수 경우 처리
        if(bridge_length == 1) return truck_weights.length+1;
        if(truck_weights.length == 1) return bridge_length+1;
        //다리에 올라갈 트럭
        int idx = 0;
        int curWeight = 0;
        while (idx < truck_weights.length) {
            curWeight -= bridge.poll();
            answer++;
            //현재 다리위의 총무게와 다음 트럭의 무게합 작거나 넘지않으면 트럭 추가 가능함
            if (curWeight + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                curWeight += truck_weights[idx++];
        }else   bridge.offer(0);
            }
        //마지막 트럭 건너는 시간까지 추가
        return answer + bridge_length;
        
    }
}
/* 제한 조건
bridge_length (다리에 트럭이 최대 올라갈 수 있는 수 ): 1 이상 10,000 이하임.
weight (다리가 견딜수 있는무게) : 1 이상 10,000 이하인
truck_weights (트럭별 무게) :
주어진 bridge_length 만큼의 크기를 갖는 큐 생성 -> 다리 상태 파악

다리의 길이 : 2
견디는 무게 : 10
다리에 올라가는데 (1) + 다리 건너는데 (2)  = 3초
다리에 올라가는데 (1) + 건너는데 (2) = 3초
다리에 올라가는데 (1) + - = 2초
다리에 올라가는데 (1) + 건너는데 (2) = 3초
총 10초

*/