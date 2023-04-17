package lv1;// 카드 뭉치(https://school.programmers.co.kr/learn/courses/30/lessons/159994)

class Programmers159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0; // cards1의 인덱스
        int index2 = 0; // cards2의 인덱스
        int len1 = cards1.length;   // cards1의 길이
        int len2 = cards2.length;   // cards2의 길이
        for(int i = 0; i < goal.length; i++) {  // goal 순회
            String str = goal[i];   // 현재 goal의 값 str
            if(index1 < len1 && str.equals(cards1[index1])) {   // index1이 cards1의 길이보다 작으면서, str이 cards1[index1]과 같으면
                index1++;   // index1 ++
            } else if (index2 < len2 && str.equals(cards2[index2])) {   // index2가 cards2의 길이보다 작으면서, str이 cards2[index2]와 같으면
                index2++;   // index2 ++
            } else {    // 그 외에는
                return "No";    // No리턴
            }
        }
        return "Yes";   // 반복문을 빠져나왔으면 Yes 리턴
    }
}
