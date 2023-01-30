package lv1;// 2016년(https://school.programmers.co.kr/learn/courses/30/lessons/12901)

class Programmers12901 {
    public String solution(int a, int b) {
        int[] days = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  // 각 월마다 있는 일 수
        String[] day = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};   // 1월 1일이 금요일부터 시작이니 FRI부터 시작
        int num = 0;
        for(int i = 1; i < a; i++) {    // a월 전까지의 일 수들을 모두 더함
            num += days[i];
        }
        num += b - 1;   // 지금 일 수 - 1을 더함
        return day[num % 7];    // day배열에서 num을 7로 나눈 나머지 인덱스에 해당하는 값 리턴
    }
}
