// 최소직사각형(https://school.programmers.co.kr/learn/courses/30/lessons/86491)

class Programmers86491 {
    public int solution(int[][] sizes) {
        int max1 = 0;   // 가장 큰 가로 길이
        int max2 = 0;   // 가장 큰 세로 길이
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] >= sizes[i][1]) {    // 가로길이가 더 클 경우
                if(sizes[i][0] > max1) {    // 가장 큰 가로길이를 찾음
                    max1 = sizes[i][0];
                }
                if(sizes[i][1] > max2) {    // 가장 큰 세로길이를 찾음
                    max2 = sizes[i][1];
                }
            } else {    // 세로가 더 클 경우, 명함을 눕혀서 세로길이를 가로길이로
                if(sizes[i][0] > max2) {    // 가장 큰 세로 길이를 찾음
                    max2 = sizes[i][0];
                }
                if(sizes[i][1] > max1) {    // 가장 큰 가로 길이를 찾음
                    max1 = sizes[i][1];
                }
            }
        }
        int answer = max1 * max2;   // 지갑의 크기
        return answer;
    }
}

