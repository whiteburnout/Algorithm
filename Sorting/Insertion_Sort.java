class Insertion_Sort {
  public static void main(String[] args) {

    int n = 5;
    int arr[] = {8, 5, 4, 7, 2};

    for(int i = 1; i < n; i++){
      for(int j = i; j > 0; j--){
        if(arr[j - 1] > arr[j]){
          int tmp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = tmp;
        }
        else
          break;
      } 
    }

    for(int i = 0; i < n; i ++){
      System.out.print(arr[i] + " ");
    }
  }
}