package lv2;// 피로도(https://school.programmers.co.kr/learn/courses/30/lessons/87946)

public class Programmers87946 {
    static int max;
    static boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        max = 0;    // max값 0
        visit = new boolean[dungeons.length];   // 방문 확인용 배열
        recur(k, dungeons, 1, 0);   // 피로도는 k, count는 1, depth는 0부터 시작
        return max; // 최종 리턴
    }

    public void recur(int k, int[][] dungeons, int count, int depth) {
        if(depth < dungeons.length) {   // depth가 dungeons의 길이보다 작으면
            for(int i = 0; i < dungeons.length; i++) {  // dungeons 순회
                if(k >= dungeons[i][0] && !visit[i]) {  // 현재 피로도가 해당던전의 최소피로도 이상이고, 방문하지 않았으면
                    visit[i] = true;    // 방문처리
                    if(max < count) max = count;    // 만약 count가 max보다 크면 max 갱신
                    recur(k - dungeons[i][1], dungeons, count + 1, depth + 1);  // 소모되고 남은 피로도, count + 1, depth + 1로 재귀
                    visit[i] = false;   // 미방문처리
                }
            }
        }
    }
}
