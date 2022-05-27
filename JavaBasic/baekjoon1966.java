// https://www.acmicpc.net/problem/1966

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());    // Test case 입력 받음
        for(int i = 0; i<N; i++){   // Test case 만큼
            StringTokenizer st = new StringTokenizer(br.readLine());    // ArrayList 길이, 순서 찾을 index 입력 받음
            ArrayList<Integer> list = new ArrayList<>();
            int firstLength = Integer.parseInt(st.nextToken()); // 첫 ArrayList 길이
            int target = Integer.parseInt(st.nextToken());   // 순서 찾을 첫 index
            StringTokenizer st2 = new StringTokenizer(br.readLine());   // ArrayList의 data 입력 받음
            for(int j = 0; j<firstLength;j++){  // ArrayList에 입력받은 data 모두 add
                list.add(Integer.parseInt(st2.nextToken()));
            }
            int count= 0;
            while(true) {    // target이 나오는 순서 찾기 while문 시작
                int max = Collections.max(list);    // list의 max
                int maxIndex = list.indexOf(max);   // max index
                if (maxIndex == target){   //max indext가 target이면 count +1 하고 while 종료
                    count++;
                    break;
                }
                if(maxIndex>target){       // max의 index가 target보다 크면
                    target = list.size()-maxIndex+target-1; //target = list의 크기 - max index + target - 1이 됨
                    for(int j = 0; j<maxIndex;j++) {   // max index만큼 반복해서
                        list.add(list.remove(0));         // List 첫 요소를 맨 뒤로 이동
                    }
                }else{                    // max의 index가 target보다 작으면
                    target = target-maxIndex-1; // target = target - max index -1이 됨

                    for(int j=0; j<maxIndex; j++){  // max index만큼 반복해서
                        list.add(list.remove(0));   // List의 첫 요소를 맨 뒤로 이동
                    }
                }
                list.remove(0); // 맨 앞 요소 제거
                count++;              // count +1
                if(list.size()==1){   // 만약 1개만 남았으면
                    count++;          // count +1 하고 while 종료
                    break;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}