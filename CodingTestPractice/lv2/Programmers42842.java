package lv2;// 카펫(https://school.programmers.co.kr/learn/courses/30/lessons/42842)

class Programmers42842 {
    public int[] solution(int brown, int yellow) {
        int max = 0;    // 큰값(가로)
        int min = 0;    // 작은값(세로)
        loop:
        for(int i = 3; i < 2500; i++) { // 가로 세로의 최대 길이는 2499임
            for(int j = 3; j < 2500; j++) {
                int num = 2 * i + 2 * j - 4;    // 가장 테두리의 넓이 num
                if(num == brown && i * j - num == yellow) { //테두리의 넓이가 brown와 같고, (총 넓이) - (테두리) 가 yellow와 같으면
                    max = Math.max(i, j);   // i와 j중 큰 값이 max
                    min = Math.min(i, j);   // i와 j중 작은 값이 min
                    break loop; // 반복문 탈출
                }
            }
        }
        return new int[]{max, min}; // max와 min 리턴
    }
}
