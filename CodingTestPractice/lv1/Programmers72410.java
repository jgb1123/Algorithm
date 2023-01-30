package lv1;// 신규 아이디 추천(https://school.programmers.co.kr/learn/courses/30/lessons/72410)

class Programmers72410 {
    public String solution(String new_id) {
        // 1단계 소문자로
        String step1 = new_id.toLowerCase();
        // 2단계 소문자, 숫자, 빼기, 밑줄, 마침표만 남기기
        String step2 = "";
        for(int i = 0; i < step1.length(); i++) {
            char c = step1.charAt(i);
            if((c >= 48 && c <= 57) ||
                    (c >= 65 && c <= 90) ||
                    (c >= 97 && c <=122) ||
                    c == 45 ||
                    c == 46 ||
                    c == 95) {
                step2 += c;
            }
        }
        // 3단계 연속된 마침표 하나로
        String step3 = "";
        step3 += step2.charAt(0);

        for(int i = 1; i < step2.length(); i++){
            if(step2.charAt(i) == '.' && step2.charAt(i-1) == '.') {
                continue;
            } else {
                step3 += step2.charAt(i);
            }
        }
        // 4단계 마침표가 처음이나 끝에 위치하면 지우기
        String step4 = step3;
        char last = step3.charAt(step3.length() - 1);
        if(step4.length() >= 2) {
            if(last == '.') {
                step4 = step4.substring(0, step4.length() - 1);
            }
        }
        char first = step3.charAt(0);
        if(step4.length() == 1 && first == '.') {
            step4 = "";
        } else if(step4.length() >= 2) {
            if(first == '.') {
                step4 = step4.substring(1, step4.length());
            }
        }
        // 5단계 빈문자열이면 a추가
        String step5 = step4;
        if(step4.length() == 0) {
            step5 = "a";
        }
        // 6단계 문자열이 16자 이상일 시 15자까지만 만들고, 마지막이 마침표면 제거
        String step6 = step5;
        if(step5.length() >= 16) {
            step6 = step5.substring(0, 15);
            if(step6.charAt(step6.length() - 1) == '.') {
                step6 = step6.substring(0, step6.length() - 1);
            }
        }
        // 7단계 길이가 2자 이하라면 길이가 3이 될때까지 마지막 문자 반복
        String step7 = step6;
        if(step7.length() <= 2) {
            while(step7.length() <= 2) {
                step7 += step7.charAt(step7.length()-1);
            }
        }
        return step7;
    }
}