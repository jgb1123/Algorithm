// https://www.acmicpc.net/problem/1110

import java.io.*;

public class baekjoon1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int sum;
        String input = br.readLine();
        int intInput = Integer.parseInt(input);
        if(input.length()==1) {
            input = "0"+input;
        }
        int A = input.charAt(0)-'0';
        int B = input.charAt(1)-'0';

        do {
            sum = A + B;
            A = B;
            B = sum % 10;
            count++;
        } while (10 * A + B != intInput);
        System.out.println(count);
    }
}