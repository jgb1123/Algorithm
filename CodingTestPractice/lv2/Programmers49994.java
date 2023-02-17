package lv2;

import java.util.*;

class Programmers49994 {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        int count = 0;
        ArrayList<String> list = new ArrayList<>(); // 지나간 길을 String으로 저장. 예시로, (0, 0) 에서 (0,-1)으로 이동하면 "000-1", "0-100"을 저장
        for(int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            int ny = getNy(y, c);   // 다음 y좌표 ny
            int nx = getNx(x, c);   // 다음 x좌표 nx
            if(checkPosition(nx, ny)) {    // 다음좌표가 맵 안에 있으면
                String str1 = String.valueOf(x) + y + nx + ny;  // 지나간 길 문자열 str1
                String str2 = String.valueOf(nx) + ny + x + y;  // 지나간 길 반대방향 문자열 str2
                x = nx; // x좌표는 nx로 갱신
                y = ny; // y좌표는 ny로 갱신
                if(!list.contains(str1)) {   // list에 지금 지나간 길이 포함되어있지 않으면
                    count++;    // count + 1
                    list.add(str1); // list에 str1 저장
                    list.add(str2); // list에 반대방향인 str2도 저장
                }
            }
        }
        return count;   // 최종 리턴
    }

    public int getNx(int x, char c) {   // 다음 x좌표를 구하는 메서드
        int nx = x;
        if(c == 'R') nx += 1;
        else if(c == 'L') nx -= 1;
        return nx;
    }

    public int getNy(int y, char c) {   // 다음 y좌표를 구하는 메서드
        int ny = y;
        if(c == 'D') ny -= 1;
        else if(c == 'U') ny += 1;
        return ny;
    }

    public boolean checkPosition(int x, int y) {    // 해당 좌표가 맵 안에 있는지 확인하는 메서드
        return x <= 5 && y <= 5 && x >= -5 && y >= -5;
    }
}
