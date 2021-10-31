class Main {

  static int n = 10;
  static int arr[] = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

  public static void main(String[] args) {
    int start = 0;
    int end = n - 1;
    int result = binary_search(start, end, 13);

    if(result == -1)
      System.out.print("None");
    else
      System.out.print(result);
  }

  static int binary_search(int start, int end, int target){
    while(start <= end){
      int mid = (start + end) / 2;
      if(arr[mid] == target)//중간이 원하던 값인 경우
        return mid;
      else if(arr[mid] > target)//중간값이 원하던 값보다 클 경宇
        end = mid - 1;
      else//중간값이 원하던 값보다 작거나 같을 경우
        start = mid + 1;
      }
    return -1;
  }
}