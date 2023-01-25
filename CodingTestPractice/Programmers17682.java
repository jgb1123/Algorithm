// [1차] 다트 게임(https://school.programmers.co.kr/learn/courses/30/lessons/17682)

class Programmers17682 {
    public int solution(String dartResult) {
        int[] score = new int[3];   // 각 판의 점수
        int index = 0;  // 해당 판 점수의 index
        for(int i = 0; i < dartResult.length(); i++){    // 기본적으로 i++만 하고, 반복문 내에서 i값을 조절해서 i는 숫자에서만 시작하도록
            String str = "";
            str += dartResult.charAt(i);    // 첫 글자는 숫자이므로 str에 저장
            if(dartResult.charAt(i+1) == '0') {    // 만약 다음 문자가 0이면 10점을 의미
                str += dartResult.charAt(i+1);  //해당 숫자도 더함
                i++;    // i+1
            }

            int num = Integer.parseInt(str);    // 점수를 의미하는 문자를 숫자로 변환
            int square = 0; //  몇제곱인지
            if(dartResult.charAt(i+1) == 'S') square = 1;   // 다음 문자가 S면 점수에 1제곱
            else if(dartResult.charAt(i+1) == 'D') square = 2;   // 다음 문자가 D면 점수에 2제곱
            else if(dartResult.charAt(i+1) == 'T') square = 3;   // 다음 문자가 T면 점수에 3제곱
            score[index] = (int) Math.pow(num, square); // 점수를 square만큼 제곱한게 해당 판의 점수
            i++;    // i+1

            if(i + 1 < dartResult.length() && dartResult.charAt(i + 1) == '*') {    // 만약 그다음 문자가 있고 *이면
                score[index] *= 2;  // 점수 2배
                if(index > 0) { // 이전 판이 있으면
                    score[index-1] *= 2;    // 이전 판의 점수도 2배
                }
                i++;    // i+1
            } else if(i + 1 < dartResult.length() && dartResult.charAt(i + 1) == '#') { // 만약 그다음 문자가 있고 #이면
                score[index] -= score[index]*2; // +점수에서 -점수로
                i++;    // i+1
            }
            index++;    // 해당 판의 인덱스 +1
        }
        int answer = 0;
        for(int i = 0; i < 3; i++){ // 모든 판의 점수 합산
            answer += score[i];
        }
        return answer;  // 반환
    }
}
