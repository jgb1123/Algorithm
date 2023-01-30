package lv1;// 개인정보 수집 유효기간(https://school.programmers.co.kr/learn/courses/30/lessons/150370)

import java.util.*;

class Programmers150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] arr = new int[26];    // 약관을 정리해서 넣을 arr
        for(int i = 0; i<terms.length; i++) {   // 각 약관들의 유효기간을 정리하며, arr[0]은 약관 A의 유효기관, arr[25]는 약관 Z의 유효기간이 저장된다.
            String str = terms[i].substring(2, terms[i].length());
            arr[terms[i].charAt(0) - 'A'] = Integer.parseInt(str);
        }
        int todayY = Integer.parseInt(today.substring(0, 4));   // 오늘 날짜 중 년수만 int로
        int todayM = Integer.parseInt(today.substring(5, 7));   // 오늘 날짜 중 월수만 int로
        int todayD = Integer.parseInt(today.substring(8, 10));  // 오늘 날짜 중 일수만 int로
        int todayResult = 10000*todayY+100*todayM+todayD;   // 나중에 날짜 비교가 쉽게 가능하도록

        ArrayList<Integer> result = new ArrayList<>();  // 만료된 개인정보의 번호를 담을 ArrayList
        for(int i = 0; i<privacies.length; i++) {   // 개인정보의 수만큼 반복
            char c = privacies[i].charAt(11);   // 약관의 알파벳
            int time = arr[c - 'A'];    // 해당 약관의 유효기간(개월)을 arr에서 가져옴
            int y = Integer.parseInt(privacies[i].substring(0, 4)); // 개인정보의 수집일자 중 년수만 int로
            int m = Integer.parseInt(privacies[i].substring(5, 7)); // 개인정보의 수집일자 중 월수만 int로
            int d = Integer.parseInt(privacies[i].substring(8, 10));// 개인정보의 수집일자 중 일수만 int로
            y += (m+time)/12;   // (개인정보 수집일자 월수 + 약관의 유효기간) / 12를 개인정보 수집일자에 더하면 개인정보 유효기간 년수가 됨
            m = (m+time)%12;    // (개인정보 수집일자 월수 + 약관의 유효기간) % 12가 개인정보 유효기간의 월수가 됨
            if(m==0){   // 하지만 개인정보의 유효기간의 월수가 0일 순 없으니, 만약 개인정보 유효기간의 월수가 12로 나누어 떨어진다면 유효기간의 년수를 -1 해주고 월수를 12로 바꿈
                y -= 1;
                m = 12;
            }
            int privaciesResult = 10000*y+100*m+d;  // 날짜비교가 쉽게 가능하도록
            if(todayResult >= privaciesResult) {    // 오늘날짜가 해당 개인정보의 유효기간 이상이면 파기해야 하므로
                result.add(i+1);    // 해당 개인정보의 번호를 ArrayList에 저장
            }
        }
        int[] answer = result.stream().mapToInt(i -> i).toArray();  // ArrayList<Integer> 에서 int[]로 변환
        return answer; // 결과 리턴
    }
}
