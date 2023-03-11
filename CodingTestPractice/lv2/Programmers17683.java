package lv2;// [3차] 방금그곡(https://school.programmers.co.kr/learn/courses/30/lessons/17683)

class Programmers17683 {
    public String solution(String m, String[] musicinfos) {
        String removedM = removeHash(m);
        String answer = "(None)";
        int answerTotalMM = 0;
        for(int i = 0; i < musicinfos.length; i++) {
            String[] str = musicinfos[i].split(",");
            int totalMM = getTotalMM(str);
            String melody = removeHash(str[3]);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < totalMM; j++) {
                sb.append(melody.charAt(j % melody.length()));
            }
            String music = sb.toString();
            if(music.contains(removedM) && totalMM > answerTotalMM) {
                answerTotalMM = totalMM;
                answer = str[2];
            }
        }
        return answer;
    }

    public int getTotalMM(String[] str) {
        String[] start = str[0].split(":");
        String[] end = str[1].split(":");
        int startMM = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        int endMM = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
        return endMM - startMM;
    }

    public String removeHash(String s) {
        return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a");
    }
}