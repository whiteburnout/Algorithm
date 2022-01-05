import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class 모험가길드 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String token[] = br.readLine().split(" ");
    int arr[] = new int[n];
    
    for(int i = 0 ; i < n; i ++){
      arr[i] = Integer.parseInt(token[i]);
    }
    Arrays.sort(arr);
    int count = 0;
    int result = 0;
    int cur;
    for(int i = 0; i < n; i++){
      cur = arr[i];
      count += 1;
      if(cur == count){
        result ++;
        count = 0;
      }
    }

    System.out.println(result);
  }
}