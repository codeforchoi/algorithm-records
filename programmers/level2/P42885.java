package level2;

import java.util.*;

public class P42885 {
	public int solution(int[] people, int limit) {

		Arrays.sort(people);
		
		int left = 0;
		int right = people.length - 1;
		
		int count = 0;
		
		while(left <= right) {
			// 두 사람이 탈 수 있는 경우
			if(people[left] + people[right] <= limit) {
				left++;
			}
			
			right--;
			count++;
		}
		
		return count;
	}
}


/*
public int solution(int[] people, int limit) {

	Arrays.sort(people);

	int sum = 0;
	int minCount = 0;
	for (int i = 0; i < people.length; i++) {
		int cur = people[i];

		if (sum + cur > limit) {
			sum = 0;
			minCount++;
		}

		sum += cur;
	}

	return minCount;
}
*/
