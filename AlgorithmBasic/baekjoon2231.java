import java.io.*;

public class baekjoon2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length(); // 입력 값의 자릿수 확인
        int N = Integer.parseInt(str);  // 입력값 int로 변환

                                            // 구해야 하는 값 M = N-(a+b+...)로 각 자리수가 모두 9일때가 가장 작은 수가 됨
        for(int i = N-9*len; i<N ; i++){    // 따라서 가능한 가장 작은수는 N-9*자릿수가 된다. 그 수 부터 1씩 증가하며 반복문 시작
            int sum = 0;    // 합계
            int num = i;
            while(num!=0){  // 각 자릿수를 sum에 더해주는 과정
                sum +=num %10;
                num /=10;
            }
            if(sum+i == N){ // 만약 sum+i가 N이면
                System.out.println(i);  //i값 출력
                return; // 종료
            }
        }
        System.out.println(0);  // 발견 못했으면 0 출력
    }
}