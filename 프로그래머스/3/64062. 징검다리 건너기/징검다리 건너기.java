class Solution {
	public static int solution(int[] stones, int k) {
		int answer=0;
		int min=1;
		int max=200000000;
		int mid=0;

		while(min<=max) {
			mid=(max+min)/2;
			if(cross(mid, stones, k)) {
				min=mid+1;
				answer=mid;
			} else {
				max=mid-1;
			}
		}
		return answer;
	}
	
	public static boolean cross(int friends, int[] stones, int k) {
		int count=0;
		
		for (int stone:stones) {
			if (friends>stone) count++;
			else count=0;
			if (count==k) return false;
		}
		return true;
	}
}
