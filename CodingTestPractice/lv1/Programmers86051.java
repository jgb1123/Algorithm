package lv1;// 없는 숫자 더하기(https://school.programmers.co.kr/learn/courses/30/lessons/86051)

class Programmers86051 {
    public int solution(int[] numbers) {
        boolean[] visit = new boolean[10];
        int answer = 0;
        for(int i = 0; i < numbers.length; i++) {   // numbers를 순회하며 나온 숫자들은 true처리
            visit[numbers[i]] = true;
        }
        for(int i = 0; i < visit.length; i++) {
            if(!visit[i]) { // 만약 안나온 숫자라면 answer에 더해줌
                answer += i;
            }
        }
        return answer;  // answer리턴
    }
}

