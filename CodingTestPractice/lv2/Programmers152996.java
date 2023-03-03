package lv2;// 시소 짝꿍(https://school.programmers.co.kr/learn/courses/30/lessons/152996)

import java.util.*;

public class Programmers152996 {
    public long solution(int[] weights) {
        HashMap<Double, Integer> map = new HashMap<>(); // map 생성
        long count = 0;
        Arrays.sort(weights);   // 작은 값부터 시작되도록 정렬
        for(int i = 0; i < weights.length; i++) {
            double num1 = weights[i];   // a랑 b의 몸무게가 같을 경우
            double num2 = weights[i] * 2.0 / 4.0;   // a랑 b가 2m, 4m에 앉았을때 평형을 이룰 경우, a는 b의 2/4
            double num3 = weights[i] * 2.0 / 3.0;   // a랑 b가 2m, 3m에 앉았을때 평형을 이룰 경우, a는 b의 2/3
            double num4 = weights[i] * 3.0 / 4.0;   // a랑 b가 3m, 4m에 앉았을때 평형을 이룰 경우, a는 b의 3/4
            // b와 평형을 이룰 수 있는 a가 있는 경우, a의 수를 더해야 함
            if(map.containsKey(num1)) count += map.get(num1);   // map에 num1이 키로 존재하면 count에 map.get(num1)을 더함
            if(map.containsKey(num2)) count += map.get(num2);   // map에 num2이 키로 존재하면 count에 map.get(num2)을 더함
            if(map.containsKey(num3)) count += map.get(num3);   // map에 num3이 키로 존재하면 count에 map.get(num3)을 더함
            if(map.containsKey(num4)) count += map.get(num4);   // map에 num4이 키로 존재하면 count에 map.get(num4)을 더함
            map.put(num1, map.getOrDefault(num1, 0 ) + 1);  // map에 num1이 키로 존재하면 해당 값 + 1, 없으면 1로 저장
        }
        return count;   // 최종 리턴
    }
}
