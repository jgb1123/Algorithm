package lv2;// 멀쩡한 사각형(https://school.programmers.co.kr/learn/courses/30/lessons/62048)

class Programmers62048 {
    public long solution(int w, int h) {
        int gcd = getGcd(w, h); // w와 h의 최대공약수를 구함

        return ((long) w * h) - (((w / gcd) + (h / gcd) - 1) * gcd);    // 최대공약수를 구하고, 해당 규칙만 찾으면 되는 문제
    }

    public int getGcd(int w, int h) {   // 두 수의 최대공약수를 구하는 메서드
        int gcd = Math.max(w, h);
        while(gcd > 0) {
            if(w % gcd == 0 && h % gcd == 0) {
                break;
            } else {
                gcd--;
            }
        }
        return gcd;
    }
}
