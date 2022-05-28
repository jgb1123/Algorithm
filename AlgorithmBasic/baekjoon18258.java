// https://www.acmicpc.net/problem/18258

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> Q = new LinkedList<>();
        int b=0;
        for (int i = 0; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a= st.nextToken();
            if ("push".equals(a)) {    // push
                b=Integer.parseInt(st.nextToken());
                Q.offer(b);
            } else if ("size".equals(a)) {    // size
                bw.write(Q.size() + "\n");
            } else if ("empty".equals(a)) {       // empty
                if (Q.isEmpty()) bw.write(1+"\n");
                else bw.write(0+"\n");
            } else if (Q.isEmpty()) {     // isEmpty
                bw.write(-1+"\n");
            } else if ("pop".equals(a)) {     // pop
                bw.write(Q.poll()+"\n");
            } else if ("front".equals(a)) {     // 맨 앞 출력
                bw.write(Q.peek()+"\n");
            } else if ("back".equals(a)) {     // 맨 뒤 출력
                bw.write(b+"\n");
            }
        }
        bw.close();
    }
}