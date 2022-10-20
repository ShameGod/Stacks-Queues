class Solution {
    HashMap<Character, Character> map = new HashMap<Character, Character>();
    Stack<Character> stack = new Stack<>();
    Character openBraket1 = '(';
    Character closeBraket1 = ')';
    Character openBraket2 = '{';
    Character closeBraket2 = '}';
    Character openBraket3 = '[';
    Character closeBraket3 = ']';
    
    public boolean isValid(String s) {
        map.put(openBraket1, closeBraket1);
        map.put(openBraket2, closeBraket2);
        map.put(openBraket3, closeBraket3);
        for(int i =0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);   
            }else if(c==map.get(stack.peek())){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
