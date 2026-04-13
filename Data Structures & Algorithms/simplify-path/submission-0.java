class Solution {
    String CURRENT_DIRECTORY = ".";
    String PREVIOUS_DIRECTORY = "..";
    String DIRECTORY_SEPERATOR = "/";

    public String simplifyPath(String path) {
        String[] directories = path.split(DIRECTORY_SEPERATOR);
        Stack<String> pathStack = new Stack<>();

        for(String op: directories)  {
            if(op == null || op.isEmpty() || op.equals(CURRENT_DIRECTORY)) {
                continue;
            } else if(op.equals(PREVIOUS_DIRECTORY)) {
                if(!pathStack.isEmpty()) pathStack.pop();
            } else {
                pathStack.push(op);
            }
        }
        
        String directoryPath = "";
        if(pathStack.isEmpty()) directoryPath = "/";

        while(!pathStack.isEmpty()) {
            directoryPath = DIRECTORY_SEPERATOR + pathStack.pop() + directoryPath;
        } 

        return directoryPath;
    }
}