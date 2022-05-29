// https://www.acmicpc.net/problem/10866

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dQ = new LinkedList<>(); // Deque 생성
        for(int i =0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push_front":
                    dQ.offerFirst(Integer.parseInt(st.nextToken())); //Deque의 offerFirst() 사용
                    break;
                case "push_back":
                    dQ.offerLast(Integer.parseInt(st.nextToken())); //Deque의 offerLast() 사용
                    break;
                case "pop_front":
                    if(dQ.isEmpty()) sb.append(-1).append("\n"); // 비어있으면 -1
                    else sb.append(dQ.pollFirst()).append("\n"); // Deque의 pollFirst() 사용
                    break;
                case "pop_back":
                    if(dQ.isEmpty()) sb.append(-1).append("\n"); // 비어있으면 -1
                    else sb.append(dQ.pollLast()).append("\n");  // Deque의 pollLast() 사용
                    break;
                case "size":
                    sb.append(dQ.size()).append("\n"); // Deque의 size()사용
                    break;
                case "empty":
                    if(dQ.isEmpty()) sb.append(1).append("\n"); // 비어있으면 1
                    else sb.append(0).append("\n");             // 아니면 0
                    break;
                case "front":
                    if(dQ.isEmpty()) sb.append(-1).append("\n"); // 비어있으면 -1
                    else sb.append(dQ.peekFirst()).append("\n"); // Deque의 peekFirst() 사용
                    break;
                case "back":
                    if(dQ.isEmpty()) sb.append(-1).append("\n"); // 비어있으면 -1
                    else sb.append(dQ.peekLast()).append("\n");  // Deque의 peekLast() 사용
                    break;
            }
        }
        System.out.println(sb); // StringBuilder 출력
    }
}