// x만큼 간격이 있는 n개의 숫자(https://school.programmers.co.kr/learn/courses/30/lessons/12954)

class Programmers12954 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i = 0; i < n; i++) {    // n번 반복
            answer[i] = (long) x*(i+1); // answer[i] 는 x*(i+1)을 하면 x만큼 간격이 있는 n개의 숫자를 구할 수 있음
        }
        return answer;
    }
}
