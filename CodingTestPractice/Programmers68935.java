// 3진법 뒤집기

class Programmers68935 {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        // 10진수 -> 3진수 역순
        while(n / 3 >= 1){
            int remain = n % 3;
            n = n/3;
            sb.append(remain);
        }
        sb.append(n);

        // 3진수 -> 10진수
        String str = sb.toString();
        int answer = 0;
        for(int i = 0; i<str.length(); i++) {
            answer += (str.charAt(str.length() - 1 - i) - '0') * Math.pow(3, i);
        }

        return answer;
    }
}