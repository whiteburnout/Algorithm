class Counting_Sort {

  static int n = 5;
  static int data [] = {8, 5, 4, 7, 2};

  public static void main(String[] args) {

    int max = 0;
    for(int i = 0; i < n; i++)
      max = Math.max(max, data[i]);
    
    int count[] = new int[max + 1];//등장 횟수를 입력할 배열 생성

    for(int i = 0; i < n; i++)//해당 배열에 횟수 기록
      count[data[i]]++;
    
    for(int i = 0; i <= max; i++){//0부터 시작해서 횟수만큼 출력
      for(int j = 0; j < count[i]; j++)
        System.out.print(i + " ");
    }

  }
}