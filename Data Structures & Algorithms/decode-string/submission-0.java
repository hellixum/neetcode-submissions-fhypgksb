class Solution {
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        for(int i=0;i<s.length(); ) {
            Character ch = s.charAt(i);

            if(Character.isLetter(ch)) {
                String subStr = "";
                while(i<s.length() && Character.isLetter(s.charAt(i))) {
                    subStr += s.charAt(i);
                    i++;
                }
                stringStack.push(subStr);
            } else if(Character.isDigit(ch)) {
                String subStr = "";
                while(i<s.length() && Character.isDigit(s.charAt(i))) {
                    subStr += s.charAt(i);
                    i++;
                }
                stringStack.push(subStr);
            } else if(ch == '[') {
                i++;
            } else if(ch == ']') {
                String decodedString = "";
                while(!stringStack.isEmpty() && getIntFromString(stringStack.peek()) == -1) {
                    decodedString = stringStack.pop() + decodedString;
                }

                decodedString = decodedString.repeat(getIntFromString(stringStack.pop()));
                stringStack.push(decodedString);
                i++;
            }
        }

        String decodedString = "";
        while(!stringStack.isEmpty()) {
            decodedString = stringStack.pop() + decodedString;
        }

        return decodedString;
    }

    Integer getIntFromString(String s) {
        if(Character.isDigit(s.charAt(0))) {
            return Integer.parseInt(s);
        } 
        return -1;
    }
}