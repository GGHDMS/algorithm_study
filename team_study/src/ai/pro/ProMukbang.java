package ai.pro;

import java.util.*;

class ProMukbang {
    public int solution(int[] food_times, long k) {
        long sum = 0;
        for(int i : food_times){
            sum += i;
        }

        if(sum <= k){
            return -1;
        }

        PriorityQueue<Food> pq = new PriorityQueue<>();

        for(int i=0;i<food_times.length;i++){
            pq.offer(new Food(food_times[i], i));
        }

        long count = food_times.length;
        long i = 0;
        long tempK = k;

        while(!pq.isEmpty()){
            Food food = pq.poll();

            long foodTime = (food.time - i) * count;

            if(tempK - foodTime < 0){
                pq.offer(food);
                break;
            }

            tempK -= foodTime;
            i += (food.time - i);
            count--;
        }

        List<Food> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }

        Collections.sort(list, (o1, o2) -> o1.index - o2.index);

        long index = tempK % (long)list.size();
        return list.get((int)index).index + 1;
    }

    public static class Food implements Comparable<Food>{
        int time;
        int index;

        public Food(int time, int index){
            this.time = time;
            this.index = index;
        }

        @Override
        public int compareTo(Food o){
            return this.time - o.time;
        }
    }
}
