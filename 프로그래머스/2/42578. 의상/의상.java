import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap();
        
        for(String[] c : clothes) {
            if(!map.containsKey(c[1])) {
                map.put(c[1], 1);
            } else {
                map.put(c[1], map.get(c[1])+1);
            }
        }
        
        Iterator it = map.values().iterator();
        
        while(it.hasNext()) {
            if(answer==0) answer = 1;
            answer *= (int)it.next()+1;
        }
        return answer-1;
    }
}