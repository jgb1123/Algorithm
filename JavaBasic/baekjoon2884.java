// https://www.acmicpc.net/problem/2884

import java.util.Scanner;
public class baekjoon2884 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();

        if(M>=45) M = M - 45;
        else {
            M = 15 + M;
            H--;
            if (H < 0) H = 23;
        }
        System.out.println(H+" "+M);
    }
}
