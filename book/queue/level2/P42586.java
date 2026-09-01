package queue.level2;

import java.util.*;

public class P42586 {
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1};
		
		System.out.println(Arrays.toString(solution(progresses, speeds)));		
		System.out.println(Arrays.toString(solution(progresses2, speeds2)));		
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> q = new ArrayDeque<>();
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < progresses.length; i++) {
			int remain = 100 - progresses[i];
			int divide = speeds[i];
			int result = remain / divide;
			int day = (remain % divide == 0) ? result : result + 1;
			//int day = (remain + speeds[i] - 1) / speeds[i];
			//int day2 = (int) Math.ceil((double)remain / divide);
			q.offer(day);
		}
		
		int maxPeriod = q.poll();
		int count = 1;
		while(!q.isEmpty()) {
			int period = q.poll();
			if(period <= maxPeriod) {
				count++;
				maxPeriod = period;
				list.add(count);
				count = 1;
			}			
		}
		list.add(count);
		return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
