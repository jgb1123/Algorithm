// 키패드 누르기(https://school.programmers.co.kr/learn/courses/30/lessons/67256)

class Programmers67256 {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;  // 왼손 위치
        int right = 11; // 오른손 위치

        int[][] dis = new int[9][];
        dis[0] = new int[]{0, 4, 3, 4, 3, 2, 3, 2, 1, 2, 1, 1};  // 0에서 0123456789*# 까지 거리
        dis[2] = new int[]{3, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4, 4};  // 2에서 0123456789*# 까지 거리
        dis[5] = new int[]{2, 2, 1, 2, 1, 0, 1, 2, 1, 2, 3, 3};  // 5에서 0123456789*# 까지 거리
        dis[8] = new int[]{1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 2, 2};  // 8에서 0123456789*# 까지 거리
        for(int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if(num == 1 || num == 4 || num == 7) {  // 1 4 7이면
                left = num; // 왼손 이동
                sb.append("L"); // 왼손 추가
            } else if(num == 3 || num == 6 || num == 9) {   // 3 6 9면
                right = num;    // 오른손 이동
                sb.append("R"); // 오른손 추가
            } else {    // 그 외에 0 2 5 8이면
                if(dis[num][left] > dis[num][right]) {  // 해당 숫자에서 오른손까지의 거리가 더 가까우면
                    right = num;    // 오른손 이동
                    sb.append("R");  //오른손 추가
                } else if(dis[num][left] < dis[num][right]) {   // 해당 숫자에서 왼손까지의 거리가 더 가까우면
                    left = num; // 왼손 이동
                    sb.append("L"); // 왼손 추가
                } else {    // 해당 숫자에서 왼손, 오른손까지의 거리가 같으면 주로 쓰는 손으로
                    if(hand.equals("left")) {
                        left = num;
                        sb.append("L");
                    } else if(hand.equals("right")) {
                        right = num;
                        sb.append("R");
                    }
                }
            }
        }
        String answer = sb.toString();
        return answer;  // 출력
    }
}
