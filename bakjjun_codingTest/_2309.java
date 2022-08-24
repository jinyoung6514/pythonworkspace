package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _2309 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = new ArrayList<Integer>();
        int sum = 0;
        for(int i = 0; i<9; i++){
            int n = Integer.parseInt(bf.readLine());
            arr.add(n);
            sum += n;
        }
        sum -= 100;
        Loop1 :
        for(int i = 0; i < 9; i++){
            for(int j = i; j < 9; j++){
                if(i == j){
                    continue;
                }
                if(arr.get(i) + arr.get(j) == sum){
                    arr.remove(j);
                    arr.remove(i);
                    break Loop1;
                }
            }
        }
        arr.sort(Comparator.naturalOrder());
        for(Integer i:arr){
            System.out.println(i);
        }
    }
}
