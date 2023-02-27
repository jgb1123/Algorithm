package lv2;// 점 찍기(https://school.programmers.co.kr/learn/courses/30/lessons/140107)

class Programmers140107 {
    public long solution(int k, int d) {
        long count = 0;
        for(long x = 0; x <= d; x += k) {   // i는 0부터 d이하까지 k씩 증가
            int maxY = (int) Math.sqrt((long) d * (long) d - x * x);    // y^2 = d^2 - x^2이므로, 가능한 가장 큰 정수의 y인 maxY를 구함
            count += maxY / k + 1;  // maxY까지 있는 k의 배수 개수 + 1 (0 고려)
        }
        return count;   // 최종 리턴
    }
}
