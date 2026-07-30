package level1;

import java.util.*;

public class P42576 {

	public static void main(String[] args) {				
		String[] arr1 = {"leo", "kiki", "eden"};
		String[] arr2 = {"eden", "kiki"};
		System.out.println(solution(arr1, arr2));
		
		String[] arr3 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] arr4 = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution(arr3, arr4));
		
		String[] arr5 = {"mislav", "stanko", "mislav", "ana"};
		String[] arr6 = {"stanko", "ana", "mislav"};
		System.out.println(solution(arr5, arr6));
	}

	public static String solution(String[] participant, String[] completion) {
		Map<String, Integer> participantCount = new HashMap<>();
		
		for(String name : participant) {
			participantCount.put(name, participantCount.getOrDefault(name, 0) + 1);
		}
		
		for(String name : completion) {
			participantCount.put(name, participantCount.get(name) - 1);
		}
		
		for(String name : participant) {
			if(participantCount.get(name) > 0) {
				return name;
			}
		}
		return "";
	}
}
