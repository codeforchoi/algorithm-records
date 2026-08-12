package array.level1;


import java.util.*;

public class P42840 {
	public static void main(String[] args) {		
		int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr2)));
	}

	public static int[] solution(int[] answers) {			
		int[] one = {1, 2, 3, 4, 5};
		int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int[] score = new int[3];
				
		for(int i = 0; i < answers.length; i++) {			
			if(answers[i] == one[i % one.length]) score[0]++;
			if(answers[i] == two[i % two.length]) score[1]++;
			if(answers[i] == three[i % three.length]) score[2]++;
		}
		
		int max = Math.max(score[0], Math.max(score[1], score[2]));
		
		int count = 0;
		for(int num : score) {
			if(num == max) count++;
		}
		
		int[] result = new int[count];
		int idx = 0;
		for(int i = 0; i < score.length; i++) {
			if(score[i] == max) {
				result[idx++] = i + 1;
			}
		}
		return result;
	}
}
