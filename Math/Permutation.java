import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Permutation {

  static int N, R;
  static int input[], numbers[];
  static boolean isSelected[];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    R = Integer.parseInt(br.readLine());

    input = new int[N];
    isSelected = new boolean[N];
    numbers = new int[R];

    String token[] = br.readLine().split(" ");
    for(int i = 0; i < N; i++){
      input[i] = Integer.parseInt(token[i]);
    }

    permutation(0);
  }

  static void permutation(int cnt){

    if(cnt == R){
      System.out.println(Arrays.toString(numbers));
      return;
    }

    for(int i = 0; i < N; i++){
      if(isSelected[i])
        continue;
      
      isSelected[i] = true;
      numbers[cnt] = input[i];
      permutation(cnt + 1);
      isSelected[i] = false;
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
[1, 3, 2]
[1, 3, 4]
[1, 3, 5]
[1, 4, 2]
[1, 4, 3]
[1, 4, 5]
[1, 5, 2]
[1, 5, 3]
[1, 5, 4]
[2, 1, 3]
[2, 1, 4]
[2, 1, 5]
[2, 3, 1]
[2, 3, 4]
[2, 3, 5]
[2, 4, 1]
[2, 4, 3]
[2, 4, 5]
[2, 5, 1]
[2, 5, 3]
[2, 5, 4]
[3, 1, 2]
[3, 1, 4]
[3, 1, 5]
[3, 2, 1]
[3, 2, 4]
[3, 2, 5]
[3, 4, 1]
[3, 4, 2]
[3, 4, 5]
[3, 5, 1]
[3, 5, 2]
[3, 5, 4]
[4, 1, 2]
[4, 1, 3]
[4, 1, 5]
[4, 2, 1]
[4, 2, 3]
[4, 2, 5]
[4, 3, 1]
[4, 3, 2]
[4, 3, 5]
[4, 5, 1]
[4, 5, 2]
[4, 5, 3]
[5, 1, 2]
[5, 1, 3]
[5, 1, 4]
[5, 2, 1]
[5, 2, 3]
[5, 2, 4]
[5, 3, 1]
[5, 3, 2]
[5, 3, 4]
[5, 4, 1]
[5, 4, 2]
[5, 4, 3]
*/