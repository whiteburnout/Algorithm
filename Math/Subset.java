import java.io.BufferedReader;
import java.io.InputStreamReader;

class Subset {

  static int N, totalCnt;;
  static int input[];
  static boolean isSelected[];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    input = new int[N];
    isSelected = new boolean[N];

    String token[] = br.readLine().split(" ");
    for(int i = 0; i < N; i++){
      input[i] = Integer.parseInt(token[i]);
    }

    subSet(0);
    System.out.println("totalCnt : " + totalCnt);
  }

  static void subSet(int cnt){
    if(cnt == N){
      ++totalCnt;
      for(int i = 0; i < N; i++){
        if(isSelected[i]){
          System.out.print(input[i] + " ");
        }
      }
      System.out.println();
      return;
    }

    isSelected[cnt] = true;
    subSet(cnt + 1);
    isSelected[cnt] = false;
    subSet(cnt + 1);
  }
}

/*
[Input Example 1]
3
1 2 3
[Output Example 1]
1 2 3 
1 2 
1 3 
1 
2 3 
2 
3 

totalCnt : 8
*/