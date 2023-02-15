package lv2;// 큰 수 만들기(https://school.programmers.co.kr/learn/courses/30/lessons/42883)

class Programmers42883 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;  // 현재 인덱스
        for(int i = 0; i < number.length() - k; i++) {  // 남겨질 숫자의 길이만큼 반복
            int max = 0;    // 맥스값
            for(int j = index; j <= i + k; j++) {   // 현재 인덱스부터 i + k까지
                int cur = number.charAt(j) - '0';
                if(max < cur) { // 만약 맥스값보다 현재 값이 크면
                    max = cur;  // 맥스값 갱신
                    index = j + 1;  // 현재 인덱스는 j + 1
                }
            }
            sb.append(max); // max값 sb에 저장
        }
        return sb.toString();   // 문자열로 변환 후 리턴
    }
}