class Solution {
    class Pair<U, V> {
        U first;
        V second;

        Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Pair<Integer, Integer>> carPosition = 
        new PriorityQueue<>((a,b) -> a.first-b.first);

        for(int i=0; i<position.length; i++) {
            carPosition.offer(new Pair(position[i], speed[i]));
        }
        
        double[] timeToReachFinish = new double[position.length];
        int i=0;
        while(!carPosition.isEmpty()) {
            Pair<Integer, Integer> currentCar = carPosition.poll();
            timeToReachFinish[i] = (double)(target - currentCar.first)/(currentCar.second);
            System.out.println(timeToReachFinish[i]);
            i++;
        }

        int numberOfFleets = 0;
        for(i=position.length-1; i>=0; i--) {
            double bottleneck = timeToReachFinish[i];
            numberOfFleets++;
            while(i>=0 && bottleneck >= timeToReachFinish[i]) i--;

            if(i>=0 && bottleneck < timeToReachFinish[i]) i++;
        }
        
        return numberOfFleets;
    }
}

// target = 10
// PQ  = [(7,1), (4, 2), (1, 2), (0, 1)];
// ttrf = [10, 4.5, 3, 3]
