package programmers;

public class 키패드_누르기 {
  public static void main(String[] args) {
    //Test1 : "LRLLLRLLRRL"
    int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
    String hand = "right";
    //Test2 : "LRLLRRLLLRR"
    // int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
    // String hand = "left";
    //Test3 : "LLRLLRLLRL"
    // int[] numbers = {1,2,3,4,5,6,7,8,9,0};
    // String hand = "right";
    System.out.println(solution(numbers, hand));
  }

  public static String solution(int[] numbers, String hand) {
    StringBuffer sb = new StringBuffer();
    
    int lPos = 10;
    int rPos = 12;
    boolean handType = hand.equals("right") ? true : false;
    for(int number : numbers){
      if(number==0) number=11;
      if(number%3==1){
        sb.append("L");
        lPos = number;
      }else if(number%3==0){
        sb.append("R");
        rPos = number;
      }else{
        int lDistance = Math.abs((number-lPos)/3 + (number-lPos)%3);
        int rDistance = Math.abs((number-rPos)/3 + (number-rPos)%3);

        if(lDistance == rDistance){
          if(handType){
            sb.append("R");
            rPos = number;
          }else{
            sb.append("L");
            lPos = number;
          }
        }else if(lDistance<rDistance){
          sb.append("L");
          lPos = number;
        }else{
          sb.append("R");
          rPos = number;
        }
      }
    }
    
    return sb.toString();
  }

}
