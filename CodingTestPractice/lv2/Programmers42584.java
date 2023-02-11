package lv2;

// 주식가격(https://school.programmers.co.kr/learn/courses/30/lessons/42584)

class Programmers42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];  // 각 시점에서 떨어지지 않은 기간을 저장할 배열
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {    // 2중 for문을 통해 prices[i]와 prices[j]를 차례대로 비교
                answer[i]++;    // 해당 기간 + 1
                if(prices[i] > prices[j]) { // 만약 prices[i]가 prices[j]보다 크면
                    break;  // 해당 반복문 탈출
                }
            }
        }
        return answer;  // 결과 리턴
    }
}
