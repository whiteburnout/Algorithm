import java.io.BufferedReader;
import java.io.InputStreamReader;

class 각자리수의합 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    func(N);
  }

  static void func(int N){   
    int sum = 0;
    while(true){

      if(N == 0)
        break;
      
      sum += N % 10;
      N /= 10;
    }
    System.out.println(sum);
  }
}