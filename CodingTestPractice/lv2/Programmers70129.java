package lv2;// 이진 변환 반복하기(https://school.programmers.co.kr/learn/courses/30/lessons/70129)

class Programmers70129 {
    static int count;
    static int remove;
    public int[] solution(String s) {
        count = 0;  // 반복 횟수
        remove = 0; // 제거된 0의 개수
        while(!s.equals("1")) {
            int num = numberOfOne(s);  // 1의 개수
            s = lenToBinary(num);   // 1의 개수를 2진법으로
            count++;    // 반복횟수 + 1
        }

        return new int[]{count, remove};    // 반복횟수, 제거된 0의 개수 리턴
    }

    public String lenToBinary(int len) {    // 숫자를 2진법(문자열)으로 변환하는 메서드
        StringBuilder sb = new StringBuilder();
        while(len > 0) {
            int remain = len % 2;
            len = len / 2;
            sb.append(remain);
        }
        sb.reverse();
        return sb.toString();
    }

    public int numberOfOne(String s) {
        int num = 0;    // 1의 개수
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {    // '0'이면
                remove++;   // 0 제거횟수 + 1
            } else {    // 1이면
                num++;  // 1의개수 + 1
            }
        }
        return num; // 1의 개수 리턴
    }
}
