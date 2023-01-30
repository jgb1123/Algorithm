package lv2;// 124 나라의 숫자(https://school.programmers.co.kr/learn/courses/30/lessons/12899)

class Programmers12899 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[]{4, 1, 2}; // 1 2 4 배열로 생성
        while(n > 0) {  // n이 0보다 클때까지만 반복
            int remain = n % 3; // 3으로 나눈 나머지
            n = n / 3;  // 3으로 나눈 몫
            sb.append(arr[remain]); // 3으로 나눈 나머지 sb에 저장
            if(remain == 0) n--;    // 만약 나머지가 0이라면 n - 1;
        }

        return sb.reverse().toString(); // 역순으로 String으로 변환 후 리턴
    }
}
