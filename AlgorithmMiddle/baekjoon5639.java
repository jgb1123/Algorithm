// https://www.acmicpc.net/problem/5639
/*
간단한 후위순회 BST문제같아 보이지만, 전위순회한 값들로 이진 트리를 만들어 후위순회를 해야 하는 문제이다.

우선 root Node를 만들었다.
그리고 전위순회한 값들을 순서대로 받으면서, 재귀를 통해 이진 트리를 만들었다.
구현 방법은 아래 코드를 참고하는게 더 보기 편할 것 같다.

그리고 나면 해당 이진 트리를 통해 후위순회를 하면 된다.

가장 고민해야 할 부분은 전위순회한 값들로 Tree를 만드는 방법이었다.
나는 결국 재귀를 통해서 루트 Node부터 쭉 값들을 비교해가며 저장하는 방식으로 만들었고, 다른 몇몇 사람들의 결과를 보니 실행 속도가 훨씬 빨랐다.
그래서 속도 향상을 위해 다르게 구현할 수 있는 방법이 있을까 생각을 해봤는데 결국 실패했다.
풀었다는 것에 의의를 두자.
*/

import java.io.*;

public class baekjoon5639 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        Node root = new Node(Integer.parseInt(br.readLine()));  // root Node 생성 (가장 첫 입력)
        String input;
        while((input = br.readLine()) != null && input.length() != 0){  // 입력값이 Null이거나 빈 문자열이면 반복문 종료
            int data = Integer.parseInt(input);
            Node curNode = new Node(data);  // 현재의 입력값을 data로 갖는 curNode 생성
            makeTree(root, curNode);    // 이진 트리 생성 메서드
        }

        postorder(root);    // rootNode로 후위 순회 메서드
        System.out.println(sb); // 최종 StringBuilder 출력

    }
    static void makeTree(Node root, Node curNode) { // 이진 트리 생성 메서드
        if(root.data > curNode.data){   // 만약 rootNode 값보다 curNode 값이 작으면
            if(root.left==null){    // root의 leftNode가 비어있으면
                root.left=curNode; // root의 leftNode로 curNode 할당
            } else {    // root의 leftNode가 비어있지 않으면
                makeTree(root.left, curNode);   // root의 leftNode와 curNode로 재귀
            }
        } else {    // root 값보다 현재 노드 값이 크면
            if(root.right==null){   // root의 rightNode가 비어있으면
                root.right=curNode; // root의 rightNode로 curNode 할당
            } else {    // root의 rightNode가 비어있지 않으면
                makeTree(root.right, curNode);  // root의 rightNode와 curNode로 재귀
            }
        }
    }

    static void postorder(Node node){   // 후위순회 메서드
        if(node.left!=null) postorder(node.left);   // leftNode가 있으면, 해당 노드로 재귀
        if(node.right!=null) postorder(node.right); // rightNode가 있으면, 해당 노드로 재귀
        sb.append(node.data).append("\n");  // 뒤에서 부터 출력
    }

    static class Node{
        int data;   // 노드의 값
        Node left;  // 노드의 왼쪽 자식노드
        Node right; // 노드의 오른쪽 자식노드

        public Node(int data) {
            this.data = data;
        }
    }
}