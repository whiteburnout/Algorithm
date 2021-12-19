import java.io.BufferedReader;
import java.io.InputStreamReader;

class Disjoint_Set {

  static int parents[];
  static int v, e;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String token[];
    token = br.readLine().split(" ");
    v = Integer.parseInt(token[0]);
    e = Integer.parseInt(token[1]);
    parents = new int[v + 1];
    make();

    for(int i = 0; i < e; i++){
      token = br.readLine().split(" ");
      int a = Integer.parseInt(token[0]);
      int b = Integer.parseInt(token[1]);
      union(a, b);
    }

    for(int i = 1 ; i <= v; i++){
      find(i);//가장 위의 부모를 가르키도록 한번 돌리기
      System.out.print(parents[i] + " ");
    }
  }

  static void make(){
    for(int i = 0; i <= v; i++){
      parents[i] = i;
    }
  }

  static int find(int a){
    if(parents[a] == a) return a;
    return parents[a] = find(parents[a]);
  }

  static void union(int a, int b){
    int aRoot = find(a);
    int bRoot = find(b);
    if(aRoot == bRoot) return;
    if(aRoot < bRoot)//작은 원소를 부모로 하도록 설정
      parents[bRoot] = aRoot;
    else
      parents[aRoot] = bRoot;
  }
}

/*
[Input Example 1]
6 4
1 4
2 3
2 4
5 6
[Output Example 1]
Parent Table: 1 1 1 1 5 5
*/