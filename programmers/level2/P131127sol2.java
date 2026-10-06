package level2;

import java.util.*;

// 슬라이딩 윈도우
public class P131127sol2 {
	
	public int solution(String[] want, int[] number, String[] discount) {
		int count = 0;
		
		Map<String, Integer> wantMap = new HashMap<>();
		for(int i = 0; i < want.length; i++) {
			wantMap.put(want[i], number[i]);
		}
		
		Map<String, Integer> discountMap = new HashMap<>();
		
		for(int i = 0; i < discount.length; i++) {
			
			String addProduct = discount[i];
			
			discountMap.put(addProduct, discountMap.getOrDefault(addProduct, 0) + 1);
			
			// 아직 10일이 안 찼으면 비교하지 않음
			if(i < 9) continue;
			
			// 10일 초과하면 가장 오래된 상품 제거
			if(i >= 10) {
				String removeProduct = discount[i - 10];
				discountMap.put(removeProduct, discountMap.get(removeProduct) - 1);
				if(discountMap.get(removeProduct) == 0) {
					discountMap.remove(removeProduct);
				}
			}
			
			if(wantMap.equals(discountMap)) {
				count++;
			}
		}
	
        return count;
    }

}
