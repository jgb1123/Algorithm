// https://www.acmicpc.net/problem/1991
/*
이진 탐색 트리의 트리 순회 방법들을 구현해보는 문제이다.

풀이 방법은 다음과 같다.
우선 Node가 들어갈 arr 배열을 만들었다.
arr 안에는 노드의 left, right 정보가 담긴 Node 객체가 들어간다.
각 노드의 이름에는 A~Z까지 들어올 수 있고,
구현하기 쉽게 알파벳에 - 'A'를 해서 A는 0, B는 1... 이 되도록 구현했다.(자식 노드가 없는 경우인 '.'은 -19가 됨)
각 노드의 data는 arr의 index가 된다. (예를 들면 arr[1]은 data가 B인 노드가 된다.)

preorder, inorder, postorder 모두 구현 방식은 같고, 순회하면서 값을 저장하는 부분만 언제 저장할 지 신경써주면 된다.
자세한 풀이는 아래 코드를 참고하면 더 이해하기 쉬울 것이다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon1991 {
    static Node[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());    // 노드의 개수

        makeNodeArray(br, N);    // 노드가 들어간 arr배열을 만드는 메서드

        preorder(0);    // 전위 순회 구현 메서드
        sb.append("\n");
        inorder(0); // 중위 순회 구현 메서드
        sb.append("\n");
        postorder(0);   // 후위 순회 구현 메서드

        System.out.println(sb); // 최종 StringBuilder 출력



    }

    private static void makeNodeArray(BufferedReader br, int N) throws IOException {    // 노드가 들어간 arr배열을 만드는 메서드
        arr = new Node[N];  // 노드 N개가 들어갈 배열 생성
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int data = st.nextToken().charAt(0)-'A';    // 노드의 data
            int left = st.nextToken().charAt(0)-'A';    // 노드의 left
            int right = st.nextToken().charAt(0)-'A';   // 노드의 rigth
            arr[data] = new Node(left, right);  // 노드의 data는 arr 배열의 index가 되도록 설계했다.
        }
    }

    // 모두 탐색 순서는 똑같이 하고 Stringbuilder에 해당 노드를 저장하는 부분만 언제 저장할 지 신경써주면 된다.
    static void preorder(int n) {   // 전위 순회 구현 메서드
        int left = arr[n].left; // 해당 노드의 왼쪽 자식 노드
        int right = arr[n].right;   // 해당 노드의 오른쪽 자식 노드
        sb.append((char)(n+'A'));   // StringBuilder에 넣을 땐 다시 char로 변경 후 넣는다.
        if(left!=-19) preorder(left);   // 만약 왼쪽 자식의 노드가 있으면 재귀
        if(right!=-19) preorder(right); // 만약 오른쪽 노드가 있으면 재귀
    }
    static void inorder(int n) {    // 중위 순회 구현 메서드
        int left = arr[n].left;
        int right = arr[n].right;
        if(left!=-19) inorder(left);
        sb.append((char)(n+'A'));   // preorder와 노드를 Stringbuilder에 저장할 때만 다르다.
        if(right!=-19) inorder(right);
    }
    static void postorder(int n) {  // 후위 순회 구현 메서드
        int left = arr[n].left;
        int right = arr[n].right;
        if(left!=-19) postorder(left);
        if(right!=-19) postorder(right);
        sb.append((char)(n+'A'));   // preorder와 노드를 Stringbuilder에 저장할 부분만 다르다.
    }

    static class Node{  // 노드 class
        int left;   // 왼쪽 자식 노드
        int right;  // 오른쪽 자식 노드

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}