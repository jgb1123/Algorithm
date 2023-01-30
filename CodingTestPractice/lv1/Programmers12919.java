package lv1;// 서울에서 김서방 찾기(https://school.programmers.co.kr/learn/courses/30/lessons/12919)

class Programmers12919 {
    public String solution(String[] seoul) {
        int x = 0;  // Kim의 인덱스
        for(int i = 0; i < seoul.length; i++) { // Kim의 인덱스를 찾아서 x에 저장
            if(seoul[i].equals("Kim")) {
                x = i;
                break;
            }
        }
        return "김서방은 " + x + "에 있다";    // 최종 출력
    }
}
