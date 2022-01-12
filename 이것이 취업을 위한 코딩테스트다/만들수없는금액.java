import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class 만들수없는금액 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    
    String token[] = br.readLine().split(" ");
    int arr[] = new int[N];
    for(int i = 0; i < N; i ++){
      arr[i] = Integer.parseInt(token[i]);
    }
    
    Arrays.sort(arr);
    int target = 1;
    for(int i = 0; i < N; i++){
      if(target < arr[i])
        break;
      target += arr[i];
    }

    System.out.println(target);
  }
}