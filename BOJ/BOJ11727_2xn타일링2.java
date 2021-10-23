import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  static int n;
  static int dp[];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    //System.out.println(n);
    dp = new int[n + 1];
    for(int i = 0; i <= n; i++){
      dp[i] = -1;
    }

    System.out.println(function(n));
  }

  static int function(int N){

    if(dp[N] != -1)
      return dp[N];

    if(N == 1)
      return 1;
    if(N == 2)
      return 3;

    return dp[N] = (function(N - 1) + 2 * function(N - 2)) % 10007;

  }
}
