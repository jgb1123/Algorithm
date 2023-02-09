package lv2;

import java.util.*;

public class Programmers17679 {
    static boolean[][] visit;
    static int count;
    static boolean go;
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];  // board를 2차원 char배열로 변환
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        count = 0;  // 총 터진 수
        go = true;  // 반복문 진행여부를 정하기 위한 변수
        while(go) {
            visit = new boolean[m][n];  // 터짐 확인용 배열
            boom(m, n, map);    // 맵에서 터지는 좌표들 확인 및 카운팅
            arrange(m, n, map); // 터진좌표 제외하고 맵 다시 정렬
        }
        return count;
    }

    public void boom(int m, int n, char[][] map) {  // 맵에서 터지는 좌표들 확인 및 카운팅하는 메서드
        go = false; // 반복문 진행여부 false로
        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < n - 1; j++) {
                char c = map[i][j];
                if(!checkEng(c)) continue;  // 만약 알파벳이 아니면 continue
                if(map[i][j + 1] == c &&    // 해당 좌표를 기준으로 4칸이 같은 알파벳이면
                        map[i + 1][j] == c &&
                        map[i + 1][j + 1] == c) {
                    go = true;  // 한번 터졌으므로 반복문 진행여부 true로
                    for(int p = i; p <= i + 1; p++) {
                        for(int q = j; q <= j + 1; q++){
                            if(!visit[p][q]) {  // 해당 좌표 블럭이 아직 터진적이 없으면 (중복 카운팅 방지)
                                count++;    // count ++;
                                visit[p][q] = true; // 해당 좌표 터짐 처리
                            }
                        }
                    }
                }
            }
        }
    }

    public void arrange(int m, int n, char[][] map) {   // 터진 좌표를 제외하고 맵을 다시 정렬하는 메서드
        for(int i = 0; i < n; i++) {
            ArrayList<Character> list = new ArrayList<>();
            for(int j = m - 1; j >= 0; j--) {   // 반복문은 맵 왼쪽 아래에서 위방향으로 진행
                if(!visit[j][i]) {  // 터지지 않은 좌표면
                    list.add(map[j][i]);    // list에 저장
                }
                map[j][i] = '0';    // 맵을 모두 '0'(빈공간)으로 초기화
            }
            for(int j = 0; j < list.size(); j++) {
                map[m - j - 1][i] = list.get(j);    // 맵 아래에서부터 list에 저장된 알파벳들 차례대로 저장 (블럭들이 아래로 떨어지게됨)
            }
        }
    }

    public boolean checkEng(char c) {   // 알파벳인지 체크하는 메서드
        return c >= 'A' && c <= 'Z';
    }
}