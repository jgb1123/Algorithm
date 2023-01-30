package lv1;

// 숫자 짝궁(https://school.programmers.co.kr/learn/courses/30/lessons/131128)
class Programmers131128 {
    public String solution(String X, String Y) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        for(int i = 0; i < X.length(); i++) {   // X에서 나온 각 숫자들의 개수를 arr1에 저장
            int num = X.charAt(i) - '0';
            arr1[num] += 1;
        }
        for(int i = 0; i < Y.length(); i++) {   // Y에서 나온 각 숙자들의 개수를 arr2에 저장
            int num = Y.charAt(i) - '0';
            arr2[num] += 1;
        }
        StringBuilder sb = new StringBuilder();
        boolean couple = false; // 최종적으로 두 수가 짝꿍인지 여부를 저장할 변수
        for(int i = 9; i >= 0; i--) {   // 큰 수를 만들어야 하므로 뒤부터 반복 (9 8 7 6 5 4 3 2 1 0 순으로)
            if(arr1[i] != 0 && arr2[i] != 0) {  // 만약 해당 숫자가 두 문자열에서 모두 나온적이 있으면
                couple = true;  // 두 수는 짝꿍이 되고
                if(arr1[i]>=arr2[i]) {  // 해당 숫자가 두 문자열 중 더 적게나온 개수 만큼 StringBuilder에 저장
                    for(int j = 0; j < arr2[i]; j++) {
                        sb.append(i);
                    }
                } else {
                    for(int j = 0; j < arr1[i]; j++) {
                        sb.append(i);
                    }
                }
            }
        }
        String answer = sb.toString();  // StringBuilder To String
        if(!couple) return "-1";    // 만약 두 수가 짝꿍이 아니면 -1 리턴

        for(int i = 0; i < answer.length(); i++){
            if(answer.charAt(i) != '0') {   // 짝꿍이면서 만약 0이 아닌 수로 짝꿍이라면
                return answer;  // 구한 수 리턴
            }
        }

        return "0"; // 그 외(짝궁이지만 0으로만 이루어진 짝꿍)
    }
}

