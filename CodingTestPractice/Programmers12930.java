// 이상한 문자 만들기(https://school.programmers.co.kr/learn/courses/30/lessons/12930)

public class Programmers12930 {
    public String solution(String s) {
        String str = s.toUpperCase();   // 문자열을 대문자로 변환
        String[] arr = str.split(" ", -1);  // 문자열을 띄어쓰기(" ")를 기준으로 나누는데, 공백도 포함하여 배열로 만듬
        int dif = 'A' - 'a';    // 아스키코드 상 대문자와 소문자간의 차이
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {   // 배열의 길이만큼 반복
            for(int j = 0; j < arr[i].length(); j++) {  // 배열의 각 문자열 길이만큼 반복
                if(j % 2 == 1) {    // 홀수번째면
                    sb.append((char) (arr[i].charAt(j) - dif)); // 해당 문자는 소문자로 변환하여 sb에 추가
                } else {
                    sb.append(arr[i].charAt(j));    // 그 외에는 그대로 sb에 추가
                }
            }
            if(i != arr.length - 1) sb.append(" "); // 문자열을 띄어쓰기 기준으로 나눠 배열로 만들었으므로, 배열의 각 문자열들의 작업이 끝나면 띄어쓰기 다시 추가 (마지막은 제외)
        }
        String answer = sb.toString();  // String으로 변환
        return answer;  // 최종 반환환
    }
}
