package problem1.service;

import java.util.PriorityQueue;

/**
 * ShakeMachine class represents a machine that prepares milkshakes.
 */
public class ShakeMachine {

    /**
     * Calculates the minimum time required to prepare milkshakes.
     * 
     * @param mangoMilkshake    The quantity of mango milkshake.
     * @param orangeMilkshake   The quantity of orange milkshake.
     * @param pineappleMilkshake The quantity of pineapple milkshake.
     * @return The minimum time required to prepare milkshakes.
     */
    public static int getMinimumTime(int mangoMilkshake, int orangeMilkshake, int pineappleMilkshake) {
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(mangoMilkshake);
        pq.offer(orangeMilkshake);
        pq.offer(pineappleMilkshake);

        while (pq.size() > 1) {
            int shake1 = pq.poll();
            int shake2 = pq.poll();

            if (shake1 > 0 && shake2 > 0) {
                time++;
                shake1--;
                shake2--;
            }

            if (shake1 > 0)
                pq.offer(shake1);
            
            if (shake2 > 0)
                pq.offer(shake2);
        }

        time += pq.poll();

        return time;
    }
}