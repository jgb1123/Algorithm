package lv2;// n^2 배열 자르기(https://school.programmers.co.kr/learn/courses/30/lessons/87390)

class Programmers87390 {
    public int[] solution(int n, long left, long right) {
        int[] arr = new int[(int)(right - left + 1)];    // arr의 길이는 right - left + 1
        int index = 0;  // arr의 index
        for(long i = left; i <= right; i++) {   // i는 left부터 right까지
            int div = (int)(i / n); // i / n
            int remain = (int)(i % n);  // i % n
            if(remain <= div) arr[index] = div + 1; // remain이 div이하이면 arr[index]는 div + 1
            else arr[index] = remain + 1;   // remian이 div보다 크면 arr[index]는 remain + 1
            index++;    // index + 1
        }
        return arr; // 최종 리턴
    }
}
