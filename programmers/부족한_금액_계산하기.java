package programmers;

public class 부족한_금액_계산하기 {
  public static void main(String[] args) {
    // Test1 : 10
    int price = 2500;
    int money = 1;
    int count = 2500;

    System.out.println(solution(price, money, count));
  }

  public static long solution(int price, int money, int count) {
    long sum = 0;
    for (int i = 1; i <= count; i++) {
      sum += price * i;
    }

    if(sum>=money) return sum-money; 

    return 0;
  }
}
