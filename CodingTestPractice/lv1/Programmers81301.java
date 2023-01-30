package lv1;// 숫자 문자열과 영단어(https://school.programmers.co.kr/learn/courses/30/lessons/81301)

class Programmers81301 {
    public int solution(String s) {
        // 영단어를 숫자로 replaceAll하면 됨
        String str1 = s.replaceAll("zero", "0");
        String str2 = str1.replaceAll("one", "1");
        String str3 = str2.replaceAll("two", "2");
        String str4 = str3.replaceAll("three", "3");
        String str5 = str4.replaceAll("four", "4");
        String str6 = str5.replaceAll("five", "5");
        String str7 = str6.replaceAll("six", "6");
        String str8 = str7.replaceAll("seven", "7");
        String str9 = str8.replaceAll("eight", "8");
        String str10 = str9.replaceAll("nine", "9");
        int answer = Integer.parseInt(str10);
        return answer;
    }
}
