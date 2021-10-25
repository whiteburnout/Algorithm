import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class DFS_and_BFS_example {

  static int n, m, start;
  static boolean visited[];
  static ArrayList<ArrayList<Integer>> al;

  public static void main(String[] args) throws Exception {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String token[] = br.readLine().split(" ");
    n = Integer.parseInt(token[0]);
    m = Integer.parseInt(token[1]);
    start = Integer.parseInt(token[2]);
    visited = new boolean[n + 1];


    //연결리스트 형태로 입력받기
    al = new ArrayList<ArrayList<Integer>>();
    for(int i = 0; i <= n; i++){
      al.add(new ArrayList<Integer>());
    }

    for(int i = 0; i < m; i++){
      token = br.readLine().split(" ");
      int from = Integer.parseInt(token[0]);
      int to = Integer.parseInt(token[1]);
      al.get(from).add(to);
      al.get(to).add(from);
    }

    DFS(start);
    //방문배열 초기화
    for(int i = 0; i < n + 1; i++)
      visited[i] = false;
      
    System.out.println();
    BFS(start);
  }

  static void DFS(int x){
    System.out.print(x + " ");
    visited[x] = true;

    int size = al.get(x).size();
    for(int i = 0; i < size; i++){
      int next = al.get(x).get(i);
      if(!visited[next])
        DFS(next);
    }
  }

  static void BFS(int x){
    Queue<Integer> q = new LinkedList<Integer>();
    q.offer(x);
    visited[x] = true;
    
    while(!q.isEmpty()){
      int cur = q.poll();
      System.out.print(cur + " ");

      int size = al.get(cur).size();
      for(int i = 0; i < size; i++){
        int next = al.get(cur).get(i);
        if(!visited[next]){
          visited[next] = true;
          q.offer(next);
        }
      }
    }
  }
}

/*
[Input Example 1]
4 5 1
1 2
1 3
1 4
2 4
3 4
[Output Example 1]
1 2 4 3 
1 2 3 4
*/