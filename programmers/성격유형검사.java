package programmers;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사 {
  public static void main(String[] args) {
    //Test1
    // String[] survey = new String[]{"AN", "CF", "MJ", "RT", "NA"};
    // int[] choices = new int[]{5, 3, 2, 7, 5};
    //Test2
    // String[] survey = new String[]{"TR", "RT", "TR"};
    // int[] choices = new int[]{7, 1, 3};
    
    String[] survey = new String[]{"TR", "RT", "TR"};
    int[] choices = new int[]{4, 4, 4};
    
    System.out.println(solution(survey, choices));
  }

  public static String solution(String[] survey, int[] choices) {
    String answer = "";
    int[] score = new int[]{0,3,2,1,0,1,2,3};
    Map<Character,Integer> maps = new HashMap<>();

    //map에 성격에 맞는 점수 부여
    for(int i=0; i<survey.length; i++){
      char category = ' ';
      if(choices[i] == 4) continue;
      else if(choices[i] < 4) category = survey[i].charAt(0);
      else if(choices[i] > 4) category = survey[i].charAt(1);

      maps.put(category, maps.getOrDefault(category, 0) + score[choices[i]]);
    }

    //동일 지표 유형 비교 후 큰 값의 키를 저장
    StringBuilder sb = new StringBuilder();
    sb.append(checkCh(maps, 'R', 'T')).append(checkCh(maps,'C','F'))
      .append(checkCh(maps,'J','M')).append(checkCh(maps,'A','N'));
    
    answer = sb.toString();
    return answer;
  } 

  public static String checkCh(Map<Character,Integer> maps, char a, char b){
    if(!maps.containsKey(a) && !maps.containsKey(b)) return Character.toString(a);
    // 키의 value를 서로 조회해서 b가 더크면 실행
    if(maps.getOrDefault(a,0) < maps.getOrDefault(b,0)){
      for(Map.Entry<Character, Integer> map : maps.entrySet()){
        //b의 key값을 찾아야함
        //문제 value값이 같은 녀석이 조회되면 다른 key값이 조회댐
        if(map.getKey() == b){
          return Character.toString(map.getKey());
        }
      }
    }
    return Character.toString(a);
  }
}
