// 문자열 내 p와 y의 개수

class Programmers12916 {
    boolean solution(String s) {
        int countP = 0; // p의 개수
        int countY = 0; // y의 개수
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'p' || c == 'P') countP++;  // 만약 'p' 또는 'P' 이면 countP + 1
            else if(c == 'y' || c == 'Y') countY++; // 만약 'y' 또는 'Y' 이면 countY + 1
        }
        return countP == countY;    // 같으면 true, 다르면 false 리턴(둘다 0개인 경우도 같으므로 true)
    }
}