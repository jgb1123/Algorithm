package lv1;// 실패율(https://school.programmers.co.kr/learn/courses/30/lessons/42889)
import java.util.*;

class Programmers42889 {
    public int[] solution(int N, int[] stages) {
        double[] cleared = new double[N+2]; // cleared[i] 는 i번째 스테이지를 깬 인원 수들
        double[] failed = new double[N+2];  // failed[i]는 i번째 스테이지에서 막힌 인원 수들
        double[] rate = new double[N+1];    // rate[i]는 i번쨰 스테이지의 실패율
        rate[0] = -1;   // 0번쨰 스테이지는 없으므로 -1로

        for(int i = 0; i < stages.length; i++) {
            int stage = stages[i];
            failed[stage] += 1; // 막힌 스테이지 +1
            for(int j = stage; j > 0; j--) {    // 막힌 스테이지 전까지는 깬 스테이지 처리
                cleared[j] += 1;
            }
        }

        for(int i = 1; i < N+1; i++) {
            if(cleared[i] == 0) {   // 만약 해당 스테이지를 클리어한 사람이 없으면
                rate[i] = 0;    // 실패율은 0
            } else {    // 그 외에는 해당 스테이지의 실패율을 구함
                rate[i] = failed[i] / cleared[i];
            }
        }

        ArrayList<Double> list = new ArrayList<>(); // rate를 ArrayList로 변환, list는 index확인용으로 사용
        for(double d : rate) {
            list.add(d);
        }

        Arrays.sort(rate);  // rate배열 오름차순 정렬
        int[] answer = new int[N];  // 실패율이 높은 스테이지부터 내림차순으로 들어갈 배열
        for(int i = 1; i < rate.length; i++) {
            int index = list.indexOf(rate[rate.length - i]);    // 오름차순으로 정렬되어 있으니, rate배열의 뒤부터 인덱스를 확인
            answer[i - 1] = index;  // answer배열에 해당 인덱스 저장
            list.set(index, -1.0);  // list에 해당 인덱스는 -1로 변경하여 중복 방지
        }
        return answer;  // 리턴
    }
}
