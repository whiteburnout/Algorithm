class Quick_Sort {

  static int n = 5;
  static int data [] = {8, 5, 4, 7, 2};

  public static void main(String[] args) {
     quick_sort(0, n - 1);
     for(int i = 0; i < n; i++){
       System.out.print(data[i] + " ");
     }
  }

  static void quick_sort(int start, int end){
    
    if(start >= end)
      return;

    int pivot = start;//피봇은 배열의 가장 앞으로 설정
    int left = start + 1;
    int right = end;
    
    while(left <= right){
      while(left <= end && data[left] <= data[pivot])//피봇보다 큰 값 찾기, end보다 커질수 있다
        left++;
      while(right > start && data[right] >= data[pivot])//피봇보다 작은 값 찾기
        right--;
      if(left > right){//left와 right가 엇갈렸을때 피봇과 작은값(right)를 바꿔줌
        swap(right, pivot);
      }
      else//엇갈리지 않았을때 left와 right를 바꿈
        swap(left, right);
    }

    quick_sort(start, right - 1);//right 기준으로 분할한다
    quick_sort(right + 1, end);
  }

  static void swap(int a, int b){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }
}