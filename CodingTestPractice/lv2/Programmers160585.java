package lv2;// 혼자서 하는 틱택토

import java.util.*;

class Programmers160585 {
    static String[] str = new String[]{"012", "345", "678", "036", "147", "258", "246", "048"}; // 빙고 케이스
    public int solution(String[] board) {
        ArrayList<Integer> o = new ArrayList<>();   // o인 위치들
        ArrayList<Integer> x = new ArrayList<>();   // x인 위치들
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length(); j++) {
                char c = board[i].charAt(j);
                if(c == 'O') o.add(3 * i + j);  // 'O'면 해당 위치 o에 추가
                else if(c == 'X') x.add(3 * i + j); // 'X'면 해당 위치 x에 추가
            }
        }
        int oBingo = getBingo(o);   // O의 빙고 수
        int xBingo = getBingo(x);   // X의 빙고 수
        int oSize = o.size();   // O의 개수
        int xSize = x.size();   // X의 개수
        if(oBingo > 0 && xBingo > 0) {  // 둘다 이긴 경우
            return 0;   // 0리턴
        }
        if(oSize < xSize) { // x가 o보다 더 많이 놓은 경우
            return 0;   // 0리턴
        }
        if(oSize - xSize >= 2) { // o가 x보다 2개이상 많이 놓은 경우
            return 0;   // 0리턴
        }
        if(oBingo > 0 && oSize != xSize + 1) {  // o가 이겼는데 o가 x보다 1개 더 많지 않으면
            return 0;   // 0리턴
        }
        if(xBingo > 0 && oSize != xSize) {  // x가 이겼는데 o의 수와 x의 수가 다를경우
            return 0;   // 0리턴
        }
        return 1;   // 그외에는 1리턴
    }

    public int getBingo(ArrayList<Integer> list) {  // 빙고 수를 찾는 메서드
        int count = 0;
        for(int i = 0; i < str.length; i++) {   // 빙고케이스들을 순회하며
            String s = str[i];  // 해당 빙고 케이스
            int a = s.charAt(0) - '0';  // 첫숫자
            int b = s.charAt(1) - '0';  // 2번째숫자
            int c = s.charAt(2) - '0';  // 3번째숫자
            if(list.contains(a) && list.contains(b) && list.contains(c)) count++;   // 해당 list에 해당 빙고 케이스의 숫자가 모두 들어있으면 count + 1
        }
        return count;
    }
}
