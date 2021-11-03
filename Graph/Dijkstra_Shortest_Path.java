import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node implements Comparable<Node>{

  private int index;
  private int distance;

  public Node(int index, int distance){
    this.index = index;
    this.distance = distance;
  }

  public int getIndex(){
    return this.index;
  }

  public int getDistance(){
    return this.distance;
  }

  @Override
  public int compareTo(Node other){
    if(this.distance < other.distance){
      return -1;
    }
    return 1;
  }
}

class Dijkstra_Shortest_Path {

  static int INF = 987654321; //무한값
  static int n, m, start; // n : 노드 개수, m : 간선 개수, start : 시작노드
  //연결 노드 정보를 담는 ArrayList
  static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
  //최단거리 테이블
  static int [] d = new int[100001];

  public static void dijkstra(int start){
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0));
    d[start] = 0;//시작점 거리 0

    while(!pq.isEmpty()){
      Node node = pq.poll();
      int dist = node.getDistance();//현재까지 비용
      int now = node.getIndex();//현재 노드

      if(d[now] < dist)//방문하지 않았을 경우 INF > dist
        continue;
      //현재 노드와 연결되어 있는 노드 확인
      for(int i = 0; i < graph.get(now).size(); i++){
        int nextNode = graph.get(now).get(i).getIndex();
        int nextCost = d[now] + graph.get(now).get(i).getDistance(); 
        //현재 노드를 거쳐서 해당 노드를 가는것이 더 가까울 경우
        if(nextCost < d[nextNode]){
          d[nextNode] = nextCost;
          pq.offer(new Node(nextNode, nextCost));
        }
      }
    }
  }


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String token[] = br.readLine().split(" ");
    n = Integer.parseInt(token[0]);
    m = Integer.parseInt(token[1]);
    start = Integer.parseInt(br.readLine());

    for(int i = 0; i <= n; i++){
      graph.add(new ArrayList<Node>());
    }

    for(int i = 0; i < m; i++){
      token = br.readLine().split(" ");
      int from = Integer.parseInt(token[0]);
      int to = Integer.parseInt(token[1]);
      int cost = Integer.parseInt(token[2]);

      graph.get(from).add(new Node(to, cost));
    }

    for(int i = 0; i <= n; i++){
      d[i] = INF;
    }

    dijkstra(start);

    for(int i = 1; i <= n; i++){
      if(d[i] == INF)
        System.out.println("INF");
      else
        System.out.println(d[i]);
    }  
  }
}