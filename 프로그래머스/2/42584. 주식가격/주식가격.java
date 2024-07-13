class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i=0; i<prices.length; i++){
            for (int j=i+1; j<prices.length; j++){
                answer[i]++;
                if(prices[i] > prices[j])
                    break;
                
            }
            
        }
        
        return answer;
    }
}
/*
초 단위로 기록된 주식 가격이 담긴 배열 Prices 가 매개변수로 주어질 때, 가격이 떨어지지 않는 기간은 몇초인지
1초 간격으로 주식 가격의 변화를 배열로 주고
가격이 떨어지지 않는 기간
*/