// 신고 결과 받기(https://school.programmers.co.kr/learn/courses/30/lessons/92334)

import java.util.*;
class Programmers92334 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int len = id_list.length;
        List<String> list = Arrays.asList(id_list); // id_list를 List로 변환
        boolean[][] already = new boolean[len][len];    // i가 j를 신고 한 여부
        int[] count = new int[len]; // i가 신고 당한 횟수
        boolean[] ban = new boolean[len];   // i가 정지된 여부
        for(int i = 0; i < report.length; i++) {
            String[] arr = report[i].split(" ");    // 공백을 기준으로 나눠서
            int from = list.indexOf(arr[0]);    // 신고한 사람 from
            int to = list.indexOf(arr[1]);  // 신고 당한 사람 to
            if(!already[from][to]) {    // from이 to를 신고한 이력이 없으면
                already[from][to] = true;   // 해당 이력을 true로 변경
                count[to] += 1; // to의 신고 당한 횟수 + 1
                if(count[to] == k){ // 만약 to의 신고당한 횟수가 k번이라면
                    ban[to] = true; // to의 정지 여부 true로 변경
                }
            }
        }
        int[] answer = new int[len];    // 각 회원들이 받을 메일 수
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(already[i][j] && ban[j]) {   // i가 j를 신고한 이력이 있고, j가 정지당한 상태라면
                    answer[i] += 1; // i가 받는 메일 수 +1
                }
            }
        }
        return answer;  // 최종 리턴
    }
}

