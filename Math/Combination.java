import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Combination {

  static int N, R;
  static int input[], numbers[];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    R = Integer.parseInt(br.readLine());

    input = new int[N];
    numbers = new int[R];

    String token[];
    token = br.readLine().split(" ");
    for(int i = 0; i < N; i++){
      input[i] = Integer.parseInt(token[i]);
    }
    combination(0, 0);
  }

  static void combination(int cnt, int start){
    
    if(cnt == R){
      System.out.println(Arrays.toString(numbers));
      return;
    }

    for(int i = start; i < N; i++){
      numbers[cnt] = input[i];
      combination(cnt + 1, i + 1);
    }
  }
}

/*
[Input Example 1]
5
3
1 2 3 4 5
[Output Example 1]
[1, 2, 3]
[1, 2, 4]
[1, 2, 5]
[1, 3, 4]
[1, 3, 5]
[1, 4, 5]
[2, 3, 4]
[2, 3, 5]
[2, 4, 5]
[3, 4, 5]

[Input Example 2]
3
3
1 2 3
[Output Example 2]
[1, 2, 3]
*/