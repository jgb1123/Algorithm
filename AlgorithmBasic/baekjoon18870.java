// https://www.acmicpc.net/problem/18870
/*
정렬을 활용해야 하는 문제이다.
일단 입력값들을 받아서 저장할 arr배열을 만들고,
그 arr배열을 정렬하기 위해 arr배열을 복사해서 sortedArr배열을 만든 후 sortedArr배열을 오름차순으로 정렬했다.
그다음 hashmap을 만들고, sortedArr배열의 맨 앞 요소부터 순회를 하며, 해당 sortedArr배열의 값을 키로, 압축 순서값을 값으로 저장했다.
그다음 다시 arr배열을 순회하며,  map에서 해당 순회한 arr배열의 값을 키로갖고있는 값을 가져와 출력하면 된다.

사실 ArrayList와 indexOf를 이용하여 같은방식으로 구현했는데 시간초과가 나서 map을 활용하여 다시풀었었다.
*/
import java.io.*;
import java.util.*;

public class baekjoon18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());    // 좌표 수

        int[] arr = new int[N]; // 입력값들을 받아 저장할 arr배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArr = arr.clone();  // arr배열을 복사해 sortedArr배열을 만들고
        Arrays.sort(sortedArr); // 오름차순으로 정렬한다.
        HashMap<Integer, Integer> map = new HashMap<>();    // hash맵을 만들고,
        int count = 0;  // 압축순서값은 0부터 시작하며
        for (int i = 0; i < N; i++) {
            if(!map.containsKey(sortedArr[i])){ // 이미 압축된 값이 아니라면
                map.put(sortedArr[i], count);   // 해당 값을 키로,  압축순서 값을 값으로 hashmap에 저장한다
                count++;    // 압축순서값은 +1이 된다.
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr[i])).append(" "); // arr[i]를 순회하며 해당 값을 키로 갖고있는 값(압축순서 값)을 차례대로 Stringbuilder에 저장한다.
        }
        System.out.println(sb); // 최종 출력
    }
}