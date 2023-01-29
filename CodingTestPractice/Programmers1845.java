// 폰켓몬(https://school.programmers.co.kr/learn/courses/30/lessons/1845)
import java.util.*;
import java.util.stream.*;

class Programmers1845 {
    public int solution(int[] nums) {
        int n = nums.length / 2;    // (nums의 길이) / 2 마리를 가져갈 수 있음
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet()); // nums를 set으로 변환하여 중복 제거
        int len = set.size();   // set의 길이

        if (len <= n) {  // 만약 set의 길이가 n 이하이면 len 리턴
            return len;
        }
        return n;   // 나머지는 n 리턴
    }
}
