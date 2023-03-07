package lv2;// 호텔 대실(https://school.programmers.co.kr/learn/courses/30/lessons/155651)

import java.util.*;

class Programmers155651 {
    public int solution(String[][] book_time) {
        ArrayList<Time> list = new ArrayList<>();
        for(int i = 0; i < book_time.length; i++) {
            String[] startArr = book_time[i][0].split(":");
            String[] endArr = book_time[i][1].split(":");
            int startHH = Integer.parseInt(startArr[0]);    // 시작 시
            int startMM = Integer.parseInt(startArr[1]);    // 시작 분
            int endHH = Integer.parseInt(endArr[0]);    // 종료 시
            int endMM = Integer.parseInt(endArr[1]);    // 종료 분
            endMM += 10;    // 종료 분 + 10
            if(endMM >= 60) {   // 만약 60이상이되었으면
                endMM -= 60;    // 종료 분 60을빼고
                endHH += 1; // 종료 시 + 1
            }
            list.add(new Time(startHH * 100 + startMM, endHH * 100 + endMM));   // 만약 시간이 16:45면 1645와 같은 숫자로 만들어서 Time객체 생성(시작시간, 종료시간)
        }

        Collections.sort(list, new Comparator<Time>() {
            @Override
            public int compare(Time t1, Time t2) {
                return t1.start == t2.start ? t1.end - t2.end : t1.start - t2.start;    // 시작시간기준 오름차순정렬(시작시간 같으면 종료시간 기준 오름차순 정렬)
            }
        });

        ArrayList<ArrayList<Time>> rooms = new ArrayList<>();   // 방들을 저장할 2차원 ArrayList 생성
        rooms.add(new ArrayList<>());   // 처음 방 생성
        rooms.get(0).add(list.get(0));  // 처음 방에 첫 타임 저장
        loop:
        for(int i = 1; i < list.size(); i++) {  // 1부터 시작(첫타임 이미 저장 됨)
            Time now = list.get(i); // 현재 타임
            for(int j = 0; j < rooms.size(); j++) { // 방들의 수만큼 반복
                ArrayList<Time> room = rooms.get(j);    // 현재 방
                Time last = room.get(room.size() - 1);  // 현재 방의 마지막 타임
                if(last.end <= now.start) { // 현재 방의 마지막 타임의 종료시간이 지금 타임의 시작시간 이하이면
                    room.add(now);  // 해당 방에 현재 타임 저장
                    continue loop;  // 다음 타임으로
                }
            }
            rooms.add(new ArrayList<>());   // 현재 타임이 반복문 다 돌아도 저장되지 못했으면 새로운 방을 만들고
            rooms.get(rooms.size() - 1).add(now);   // 새로운 방에 현재 타임 저장
        }

        return rooms.size();    // 방의 갯수 리턴
    }
}

class Time {    // 시작시간과 종료시간을 저장할 Time 생성
    int start;  // 시작시간
    int end;    // 종료시간
    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
