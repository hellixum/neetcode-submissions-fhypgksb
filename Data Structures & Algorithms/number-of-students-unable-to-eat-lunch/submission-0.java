class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> stdQueue = new LinkedList<>();
        for(int student : students) {
            stdQueue.offer(student);
        }

        for(int i=0; i<sandwiches.length; i++) {
            if(stdQueue.isEmpty()) return 0;
            int numberOfStudents = stdQueue.size();
            while(numberOfStudents >= 0 && stdQueue.peek() != sandwiches[i]) {
                numberOfStudents--;
                Integer tempStd = stdQueue.poll();
                stdQueue.offer(tempStd);
            }
            if(numberOfStudents>0) stdQueue.poll();

            if(numberOfStudents < 0) return stdQueue.size();
        }

        return stdQueue.size();
    }
}