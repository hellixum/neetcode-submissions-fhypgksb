class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<String> groupedChar = new Stack<>();

        for(char c : s.toCharArray()) {
            String ch = Character.toString(c);
            if(groupedChar.isEmpty()) {
                groupedChar.push(ch);
            } else {
                String tc = groupedChar.peek();

                if(ch.charAt(0) == tc.charAt(0)) groupedChar.push(groupedChar.pop() + ch);
                else groupedChar.push(ch);
            }

            if(groupedChar.peek().length() == k) groupedChar.pop();
        }

        String ans = "";
        while(!groupedChar.isEmpty()) {
            ans = groupedChar.pop() + ans;
        }
        
        return ans;
    }
}