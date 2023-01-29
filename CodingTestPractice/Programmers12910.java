import java.util.*;

class Programmers12910 {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {   // arr의 길이만큼 반복
            if(arr[i] % divisor == 0) list.add(arr[i]); // 만약 arr[i]가 divisor로 나누어 떨어지면 list에 추가
        }

        if(list.size() == 0) return new int[]{-1};  // list의 길이가 0이면 배열에 -1을 담아 리턴

        Collections.sort(list); // list 오름차순 정렬

        return list.stream().mapToInt(i -> i).toArray();    // list를 int[]로 변환하여 리턴
    }
}
