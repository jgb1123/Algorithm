package lv2;

class Programmers84512 {
    static char[] arr = new char[]{'A', 'E', 'I', 'O', 'U'};
    static int count;
    static boolean found;   // 재귀 속 반복문 실행 여부를 정함 (true가 되면 재귀 내 반복문 동작 안하도록 탈출)
    public int solution(String word) {
        count = 0;  // count는 0부터
        found = false;  // found는 false
        recur("", word, 0); // 빈문자열과 depth는 0부터 재귀 시작
        return count;   // 최종 리턴
    }

    public void recur(String s, String word, int depth) {
        if(depth < 5) { // depth가 5미만일 경우에만
            for(int i = 0; i < arr.length; i++) {   // arr 모두 순회
                if(!found){ // 아직 찾지 못했으면
                    count++;    // count + 1
                    String str = s + arr[i];    // str은 s + arr[i]
                    if(str.equals(word)) {  // str이 word와 같으면
                        found = true;   // 찾음 처리
                        return; // 탈출
                    }
                    recur(str, word, depth + 1);    // str, word, depth + 1로 재귀
                }
            }
        }
    }
}
