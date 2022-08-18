package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 신고_결과_받기 {
  public static void main(String[] args) {
    // String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    // String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
    // int k=2;

    String[] id_list = {"con", "ryan"};
    String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
    int k=3;

    int[] answer = solution(id_list, report, k);
    for(int i=0; i<answer.length; i++){
      System.out.println(answer[i]);
    }    
  }

  public static int[] solution(String[] id_list, String[] report, int k) {
    int[] answer = new int[id_list.length];
    StringTokenizer st;
    Map<String,Integer> maps = new HashMap<>();
    Map<String,Integer> resultMaps = new HashMap<>();
    String[] userId = new String[report.length];
    String[] annId = new String[report.length];
    List<String> lists = new ArrayList<>();
    //신고자 중복 제거
    Set<String> set = new HashSet<>(Arrays.asList(report));
    report = set.toArray(new String[0]);

    //신고자, 피신고자 분리
    for(int i=0; i<report.length; i++){
      st = new StringTokenizer(report[i]);
      userId[i] = st.nextToken();
      annId[i] = st.nextToken();

      //map에 신고당한유저 횟수 카운트
      if(!maps.containsKey(annId[i])) maps.put(annId[i], 1);
      else maps.replace(annId[i], maps.get(annId[i])+1); 
    }

    for(Map.Entry<String, Integer> map : maps.entrySet()){
      if(map.getValue() >= k){
        lists.add(map.getKey());
      }
    }

    //피신고자 중 정지당한 id를 찾고 신고자를 resultMap에 id, 발송받을 횟수 넣기
    for (String list : lists) {
      for (int i = 0; i < report.length; i++) {
        if(list.equals(annId[i])){
          //userid[i] = 신고자
          if(!resultMaps.containsKey(userId[i])) resultMaps.put(userId[i], 1);
          else resultMaps.put(userId[i], resultMaps.get(userId[i])+1);
        }
      }
    }

    //answer에 return 값 추출
    for(Map.Entry<String, Integer> resultMap : resultMaps.entrySet()){
      for (int i = 0; i < id_list.length; i++) {
        if(resultMap.getKey().equals(id_list[i])){
          answer[i] = resultMap.getValue();
        }
      }
    }

    return answer;
  }
}
