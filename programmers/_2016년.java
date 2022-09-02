package programmers;

public class _2016년 {
  public static void main(String[] args) {
    //Test : TUE
    int a = 5;
    int b = 24;

    System.out.println(solution(a, b));
  }

  public static String solution(int a, int b) {
    int dayOfMonth[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    String[] month = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
    int year=2016;
    int totDays = (year-1)*365+b;
    for(int i=1; i<a; i++){
      totDays += dayOfMonth[i];
    }

    int test=0;
    for(int i=1; i<year; i++){
      if((i%100!=0 && i%4==0) || i%400==0){
        totDays+=1;
        test+=1;
        System.out.println(i);
      }
    }
    System.out.println(test);
    //2016년이 2월이면
    if(a>=3) totDays+=1;
    
    return month[totDays%7];
  }
}
