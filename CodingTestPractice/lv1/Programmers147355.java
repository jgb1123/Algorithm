package lv1;// 크기가 작은 부분문자열(https://school.programmers.co.kr/learn/courses/30/lessons/147355)

class Programmers147355 {
    public int solution(String t, String p) {
        int tLen = t.length();  // 문자열 t의 길이
        int pLen = p.length();  // 문자열 p의 길이
        long intP = Long.parseLong(p);  // 문자열 p를 long으로 변환
        int answer = 0; // 최종 결과값 0에서 시작

        for(int i = 0; i <= tLen-pLen; i++){    // (문자열 t의 길이) - (문자열 p의 길이) + 1 만큼 반복
            long part = Long.parseLong(t.substring(i, i+pLen)); // t의 부분문자열을 구해서 long으로 변환
            if(part <= intP) {  // 만약 해당 부분 문자열의 수가 p의 수 이하이면
                answer++;   // answer++
            }
        }
        return answer;  // 결과 리턴
    }
}