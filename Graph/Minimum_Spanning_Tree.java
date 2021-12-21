import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge>{

  private int distance;
  private int nodeA;
  private int nodeB;

  public Edge(int distance, int nodeA, int nodeB){
    this.distance = distance;
    this.nodeA = nodeA;
    this.nodeB = nodeB;
  }

  public int getDistance(){
    return this.distance;
  }

  public int getNodeA(){
    return this.nodeA;
  }

  public int getNodeB(){
    return this.nodeB;
  }

  @Override
  public int compareTo(Edge other){
    if(this.distance < other.distance){
      return -1;
    }
    return 1;
  }
}

class Minimum_Spanning_Tree {

  static int v, e, result;
  static int[] parent;
  static ArrayList<Edge> edges;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    v = Integer.parseInt(br.readLine());
    e = Integer.parseInt(br.readLine());
    parent = new int[v + 1];
    edges = new ArrayList<Edge>();
    make();

    String token[];
    for(int i = 0; i < e; i++){
      token = br.readLine().split(" ");
      int a = Integer.parseInt(token[0]);
      int b = Integer.parseInt(token[1]);
      int cost = Integer.parseInt(token[2]);
      edges.add(new Edge(cost, a, b));
    }

    Collections.sort(edges);
    int cnt = 0;
    for(int i = 0; i < edges.size(); i++){
      int cost = edges.get(i).getDistance();
      int a = edges.get(i).getNodeA();
      int b = edges.get(i).getNodeB();

      if(union(a, b)){
        result += cost;
        cnt++;
        if(cnt == v - 1)
          break;
      }
    }
    System.out.println(result);
  }

  static void make(){
    for(int i = 1; i <= v; i++){
      parent[i] = i;
    }
  }

  static int find(int a){
    if(parent[a] == a) return a;
    return parent[a] = find(parent[a]);
  }

  static boolean union(int a, int b){
    int aRoot = find(a);
    int bRoot = find(b);
    if(aRoot == bRoot) return false;
    parent[bRoot] = aRoot;
    return true;
  }
}