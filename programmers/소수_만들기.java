package programmers;

public class 소수_만들기 {
  public static void main(String[] args) {
    //Test1: 1
    // int[] nums = {1,2,3,4};
    //Test2: 4
    int[] nums = {1,2,7,6,4};

    System.out.println(solution(nums));
  }

  public static int solution(int[] nums) {
    int answers = 0;
    int n = nums.length;
    for(int i=0; i<n-2; i++){
      for(int j=i+1; j<n-1; j++){
        for(int k=j+1; k<n; k++){
          int a = nums[i] + nums[j] + nums[k];
          for(int l=2; l<a+1; l++){
            if(a==l) answers++;
            if(a%l==0){
              break;
            }
          }
        }
      }
    }

    return answers;
  }
}
