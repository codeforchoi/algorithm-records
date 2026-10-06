package level2;

import java.util.*;

public class P131127 {
	public int solution(String[] want, int[] number, String[] discount) {
		int count = 0;
		
		Map<String, Integer> wantMap = new HashMap<>();
		for(int i = 0; i < want.length; i++) {
			wantMap.put(want[i], number[i]);
		}
		
		for(int i = 0; i < discount.length - 9; i++) {
			Map<String, Integer> discountMap = new HashMap<>();
			
			for(int j = i; j < i + 10; j++) {
				discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
			}
			
			boolean canDiscountAll = true;
			
			for(String key : wantMap.keySet()) {
				// key를 안가지고 있거나 할인 횟수가 다를 경우
				if(!discountMap.containsKey(key) || wantMap.get(key) != discountMap.get(key)) {
					canDiscountAll = false;
					break;
				}				
			}
			
			if(canDiscountAll) {
				count++;
			}
		}
	
        return count;
    }
}
