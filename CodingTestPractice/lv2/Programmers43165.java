package lv2;

class Programmers43165 {
    static int count;
    public int solution(int[] numbers, int target) {
        count = 0;
        recur(0, 0, numbers, target);   // index는 0, sum은 0으로 재귀 시작
        return count;   // count 리턴
    }

    public void recur(int index, int sum, int[] numbers, int target) {
        if(index < numbers.length) {    // index가 numbers의 길이보다 작으면
            recur(index + 1, sum + numbers[index], numbers, target);    // index + 1, sum + numbers[index]로 재귀
            recur(index + 1, sum - numbers[index], numbers, target);    // index + 1, sum - numbers[index]로 재귀
        } else {    // index가 numbers의 길이와 같아졌을때
            if(sum == target) count++;  // sum이 target과 같으면 count + 1
        }
    }
}
