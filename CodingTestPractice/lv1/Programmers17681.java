package lv1;// [1차] 비밀지도(https://school.programmers.co.kr/learn/courses/30/lessons/17681)

class Programmers17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] map1 = getMap(arr1, n); // 지도1
        int[][] map2 = getMap(arr2, n); // 지도2
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {    // 빈 문자열로 초기화
            answer[i] = "";
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map1[i][j] == 0 && map2[i][j] == 0) {    // 지도1과 지도2에서 모두 공백이면
                    answer[i] += " ";   // 공백 추가
                } else {    // 그외에는
                    answer[i] += "#";   // 벽을의미하는 # 추가
                }
            }
        }
        return answer;  // 결과 반환
    }
    static int[][] getMap(int[] arr, int n) {   // 암호화된 배열로 지도를 만드는 메서드
        int[][] map = new int[n][n];    // 지도로 사용할 2차원 int 배열 생성
        for(int i = 0; i < n; i++) {
            int num = arr[i];   // 2진수로 변환할 숫자
            int index = n - 1;  // 2진수로 변환 시 사용할 index (뒤부터 채워짐)
            while(num > 0) {    // 2진수로 변환하여 map에 저장 (num이 0보다 클때까지만 반복)
                map[i][index] = num % 2;    // num을 2로 나눈 나머지가 해당 index에 들어감
                num = num / 2;  // num 은 num / 2가 됨
                index--;    // index는 한칸 앞으로 이동
            }
        }
        return map; // 해당 지도 리턴
    }
}
