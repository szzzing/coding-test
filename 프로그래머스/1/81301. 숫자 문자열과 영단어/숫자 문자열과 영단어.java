class Solution {
    public int solution(String s) {

		String[] eng = new String[] {
				"zero", "one", "two", "three", "four",
				"five", "six", "seven", "eight", "nine"
		};
        
		for(int i=0 ; i<eng.length ; i++) {
			s = s.replaceAll(eng[i],i+"");
		}
		
        return Integer.parseInt(s);
	}
}