package lv2;// 2개 이하로 다른 비트(

class Programmers77885 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {   // numbers[i]가 짝수면
                answer[i] = numbers[i] + 1; // answer[i]는 해당 숫자 + 1
            } else {    // 홀수면
                String binary = Long.toBinaryString(numbers[i]);    // 2진수로 변환
                int lastZero = binary.lastIndexOf("0"); // 0이나오는 마지막 인덱스
                if(lastZero == -1) {    // 0이 없으면
                    binary = "10" + binary.substring(1);   // 맨 앞에있는 1 대신 10추가
                    answer[i] = Long.parseLong(binary, 2);  // answer[i]는 해당 수를 10진수로 변환
                } else {    // 0이 있으면
                    binary = binary.substring(0, lastZero) + "10" + binary.substring(lastZero + 2); // 마지막에 나오는 "01"을 "10"으로 변경
                    answer[i] = Long.parseLong(binary, 2);  // answer[i]는 해당 수를 10진수로 변환
                }
            }
        }
        return answer;  // 최종 리턴
    }
}
