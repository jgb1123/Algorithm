// 행렬의 덧셈(https://school.programmers.co.kr/learn/courses/30/lessons/12950)

class Programmers12950 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int len1 = arr1.length;
        int len2 = arr1[0].length;
        int[][] answer = new int[len1][len2];
        for(int i = 0; i < len1; i++) {
            for(int j = 0; j < len2; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j]; // 두 배열에서 같은 인덱스에 해당하는 값들끼리 더한 값을 answer배열에 저장
            }
        }
        return answer;
    }
}
