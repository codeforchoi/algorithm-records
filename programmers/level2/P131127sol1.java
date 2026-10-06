package level2;

import java.util.*;

public class P131127sol1 {
	public int solution(String[] want, int[] number, String[] discount) {
		int count = 0;
		
		Map<String, Integer> wantMap = new HashMap<>();
		for(int i = 0; i < want.length; i++) {
			wantMap.put(want[i], number[i]);
		}
		
		for(int i = 0; i < discount.length - 9; i++) {
			Map<String, Integer> discountMap = new HashMap<>();
			
			for(int j = i; j < i + 10; j++) {
				if(wantMap.containsKey(discount[j])) {
					discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
				}
			}
			
			// keySet을 가져와서 비교하므로 유용하다.
			if(wantMap.equals(discountMap)) {
				count++;
			}			
		}
	
        return count;
    }
}
