// https://www.acmicpc.net/problem/2525

import java.util.Scanner;
public class baekjoon2525 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int mLater = sc.nextInt();
        if(m+mLater<60) m = m + mLater;
        else {
            h = h + (m+mLater)/60;
            m = (m + mLater)%60;
            if (h >= 24) h -= 24;
        }
        System.out.println(h+" "+m);
    }
}

