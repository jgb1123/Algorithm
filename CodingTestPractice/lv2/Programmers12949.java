package lv2;

class Programmers12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];  // 행렬의 곱 answer의 길이는 [arr1.length][arr2[0].length]로
        for(int i = 0; i < arr1.length; i++) {  // i는 0부터 arr1.length 전까지
            for(int j = 0; j < arr2[0].length; j++) {   // j는 0부터 arr2[0].length 전까지
                for(int k = 0; k < arr1[0].length; k++) {   // k는 0부터 arr[0].length 전까지
                    answer[i][j] += arr1[i][k] * arr2[k][j];    // answer[i][j]에 arr1[i][k] * arr2[k][j]를 더함
                }
            }
        }
        return answer;  // 최종 리턴
    }
}
