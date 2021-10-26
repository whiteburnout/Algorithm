
class Selection_Sort {
  public static void main(String[] args) {

    int n = 5;
    int arr[] = {8, 5, 4, 7, 2};

    for(int i = 0; i < n; i++){
      int min = i;
      for(int j = i; j < n; j++){
        if(arr[min] > arr[j])
          min = j;
      }
      int tmp = arr[i];
      arr[i] = arr[min];
      arr[min] = tmp;
    }

    for(int i = 0; i < n; i++){
      System.out.print(arr[i] + " ");
    }
  }
}
