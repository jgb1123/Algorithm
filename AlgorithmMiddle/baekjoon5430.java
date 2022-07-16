// https://www.acmicpc.net/problem/5430
/*
문제는 생각보다 어렵지 않았지만, 중간에 파싱도 해야되고 조금 코드가 길어져서 시간이 좀 걸렸다.
배열을 뒤집을때, 시간초과가 되지 않도록 시간복잡도를 줄이려고 나름 노력했지만,
다른사람들의 풀이를 보니 결국 덱을 사용하는게 빠르고 더 간단한 것 같았다. (덱을 사용하는게 더 좋은 방법이었다.)
그래도 내가 구현한 방식도 시간초과없이 잘 pass되었다. (조금 느리긴했다..)

배열을 뒤집을때마다 진짜로 배열을 뒤집으면 연산이 많아질거라 생각해서, 배열을 실제로 뒤집지 않도록 구현했다.
뒤집힌 상태 여부를 boolean 변수인 reverse로 판별하면서 reverse에 따라 다르게 동작하도록 구현했다.
배열에서 맨 앞 요소를 제거할 때, 제거된 요소는 0으로 변경했다.
요소를 제거할 때마다 removeCount++을 해줬다. (removeCount가 arr.length-1보다 커지면 error출력)
뒤집히지 않은 상태에서는, arr[removeIndex]를 0으로 만들고 removeIndex++을 해준다.
뒤집힌 상태에서는, arr[reverseRemoveIndex]를 0으로 만들고 reverseRemoveIndex--를 해준다. (reverseRemoveIndex는 arr.length-1부터 시작)

그리고 최종적인 출력은, 뒤집히지 않은 상태면 앞에서부터 0이 아닌 값들을 출력하고,
뒤집힌 상태면 뒤에서부터 0이 아닌 값들을 출력한다.

위와같이 구현할 때 그냥 덱을 썼으면 더 간단하고 빨랐을 것이다.
다음에 비슷한 상황이 생기면 꼭 덱을 써야겠다.
*/

import java.io.*;
import java.util.ArrayList;

public class baekjoon5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {   // Test 반복 횟수
            String p = br.readLine();   // 수행할 함수로, R은 뒤집기 D는 제거
            int n = Integer.parseInt(br.readLine());    // 배열 수

            int[] arr = new int[n]; // 배열 생성
            String x = br.readLine();   // 배열 요소들의 입력을 "[1,2,3,4]"와 같은 문자열로 준다.
            if(n>0) {   // 만약 배열의 길이가 1이상이면
                String[] split = stringToStringArray(x);    // 문자열을 문자열배열로 변환하고
                for (int j = 0; j < split.length; j++) {    // 반복문을 사용해서
                    arr[j] = Integer.parseInt(split[j]);    // arr배열에 각 값들을 저장한다
                }
            }

            int removeIndex = 0;    // 뒤집히지 않았을때 제거할 index
            int reverseRemoveIndex = arr.length-1;  // 뒤집혔을때 제거할 index
            int removeCount = 0;    //  제거한 수
            boolean reverse = false;    // 뒤집힌 여부
            boolean error = false;  // 에러 여부
            for (int j = 0; j < p.length(); j++) {  // 수행할 함수의 길이만큼 반복
               char c = p.charAt(j);
                if(c=='R'){ // 만약 R이면
                    reverse = !reverse; // reverse의 상태를 변경함
                } else if(c=='D') { // 만약 D면
                    if(removeCount==arr.length){    // 제거한 요소 수와 arr의 길이와 같아지면
                        sb.append("error\n");   //에러 StringBuilder에 저장하고
                        error = true;   // 에러 여부 true로 변경
                        break;  // 반복문 종료
                    }
                    if(!reverse) {  // 만약 뒤집히지 않은 상태면
                        arr[removeIndex]=0; // arr[removeIndex]를 0으로 변경 (제거처리)
                        removeIndex++;  // removeIndex+1
                    } else {    // 만약 뒤집힌 상태면
                        arr[reverseRemoveIndex]=0;  // arr[reverseRemoveIndex]는 0으로 변경 (제거처리)
                        reverseRemoveIndex--;   // reverseRemoveIndex -1
                    }
                    removeCount++;  // 제거 수 +1
                }
            }
            if(error) continue; // 만약 에러가 났으면 다음 테스트케이스 실행
            String result = getStringResult(arr, reverse);  // 현재 arr의 값을 다시 "[1,2,3,4]"와같은 문자열로 변경
            sb.append(result).append("\n"); // 해당 문자열 StringBuilder에 추가

        }
        System.out.println(sb); // StringBuilder 최종 출력
    }

    public static String[] stringToStringArray(String x) {  // "[1,2,3,4]"와 같은 문자열을 배열로 변경하는 메서드
        return x.replaceAll("\\[", "")  // [를 없애고
                .replaceAll("\\]", "")  // ]를 없애고
                .split(",");    // 구분자는 ,로 split
    }
    public static String getStringResult(int[] arr, boolean reverse) {  // 배열을 "[1,2,3,4]"와 같은 문자열로 변경하는 메서드
        ArrayList<Integer> list = new ArrayList<>();    // ArrayList 생성
        if(!reverse){   // 뒤집히지 않은 상태면
            for (int j = 0; j < arr.length; j++) {  // 앞에서부터
                if(arr[j]!=0) list.add(arr[j]); // 0이 아닌 수(제거되지 않은 수)들 list에 저장
            }
        }else{  // 뒤집힌 상태면
            for (int j = arr.length-1; j >=0 ; j--) {   // 뒤에서부터
                if(arr[j]!=0) list.add(arr[j]); // 0이 아닌 수(제거되지 않은 수)들 list에 저장
            }
        }
        return list.toString().replaceAll(" ", ""); // list를 String으로 바꾸고, 띄어쓰기 삭제 후 반환
    }
}