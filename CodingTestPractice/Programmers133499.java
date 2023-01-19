// 옹알이 (2) (https://school.programmers.co.kr/learn/courses/30/lessons/133499)

class Programmers133499 {
    public int solution(String[] babbling) {
        String[] arr = {"aya", "ye", "woo", "ma"};  // 가능한 발음
        String[] repeat = {"ayaaya", "yeye", "woowoo", "mama"}; // 불가능한 연속 발음
        int answer = 0; // 발음가능한 문자열 수
        point:  // 루프 포인트
        for(int i = 0; i < babbling.length; i++) {
            String now = babbling[i];   // 현재 문자열
            for(int j = 0; j < 4; j++) {    // 불가능한 연속 발음들은 X로 변환
                now = now.replaceAll(repeat[j], "X");
            }
            for(int j = 0; j < 4; j++) {    // 가능한 발음들은 O로 변환
                now = now.replaceAll(arr[j], "O");
            }
            for(int j = 0; j < now.length(); j++) { // 변환된 문자열이 O외에 문자가 남아있으면 루프포인트로 이동하여 다음 문자열 검사
                if(now.charAt(j) != 'O'){
                    continue point;
                }
            }
            answer++;   // 변환 완료된 문자열이 모두 O이므로 answer++;
        }
        return answer;  // 발음가능한 문자열 수 최종 반환
    }
}