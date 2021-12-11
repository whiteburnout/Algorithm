import java.io.BufferedReader;
import java.io.InputStreamReader;

class Floyd_Warshall {

  static int INF = 987654321;
  static int dist[][];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    dist = new int[n + 1][n + 1];

    //자기자신은 0 나머지 INF
    for(int i = 1; i < n + 1; i++){
      for(int j = 1; j < n + 1; j++){
        if(i == j)
          dist[i][j] = 0;
        else
          dist[i][j] = INF;
      }
    }

    String token[];

    //연결 값 최소값으로 넣기
    for(int i = 0; i < m; i++){
      token = br.readLine().split(" ");
      int from = Integer.parseInt(token[0]);
      int to = Integer.parseInt(token[1]);
      int cost = Integer.parseInt(token[2]);

      dist[from][to] = Math.min(cost, dist[from][to]);
    }

    //플로이드와샬
    for(int k = 1; k < n + 1; k++){
      for(int i = 1; i < n + 1; i++){
        for(int j = 1; j < n + 1; j++){
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }

    for(int i = 1; i < n + 1; i++){
      for(int j = 1; j < n + 1; j++){
        if(dist[i][j] == INF)
          System.out.print(0 + " ");
        else
          System.out.print(dist[i][j] + " ");
      }
      System.out.println();
    }

  }
}

/*
[Input Example 1]
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4

[Output Example 1]
0 2 3 1 4
12 0 15 2 5
8 5 0 1 1
10 7 13 0 3
7 4 10 6 0
*/