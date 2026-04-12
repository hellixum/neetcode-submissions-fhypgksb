class Solution {
    class Pair<U, V> {
        U first;
        V second;

        Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Pair<Integer, Integer>> nextWarmerDay = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i=temperatures.length-1; i>=0; i--) {
            while(!nextWarmerDay.isEmpty() && nextWarmerDay.peek().first <= temperatures[i]) {
                nextWarmerDay.pop();
            }
            
            if(nextWarmerDay.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = nextWarmerDay.peek().second - i;
            }
            nextWarmerDay.push(new Pair<>(temperatures[i], i));
        }

        return result;
        
    }
}