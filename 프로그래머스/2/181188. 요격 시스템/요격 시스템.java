import java.util.*;

public class Solution {
	
	public int solution(int[][] targets) {
        ArrayList<Target> targetList = new ArrayList();
        int answer = 0;
        
        for(int[] t : targets) {
            Target target = new Target(t[0], t[1]);
            targetList.add(target);
        }
        Collections.sort(targetList);
        
        int x1 = 100000000;
        for(int j=0 ; j<targetList.size() ; j++) {
            Target t = targetList.get(j);
            
            if(t.x1>x1) {
                x1 = t.x1;
            } else if(t.x2<=x1) {
                x1 = t.x1;
                answer++;
            }
        }
		return answer;
	}
}

class Target implements Comparable<Target> {
    int x1;
    int x2;
    
    public Target(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
    @Override
    public int compareTo(Target t) {
        if(this.x2==t.x2) return t.x1-this.x1;
        else return t.x2-this.x2;
    }
}