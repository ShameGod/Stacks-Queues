class Solution {
    public int numSquares(int n) {
        if(n<4) {return n;}
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.add(n);
        int steps = 1;
        while(!queue.isEmpty()){
            for(int i=queue.size(); i>0; i--){
                int it = queue.peek();
                int intSquare = (int) Math.sqrt(it);
                for(int j=1; j<=intSquare; j++){
                    int result = it - j*j; 
                    if(result == 0){return steps;}
                    if(result < 0 || set.contains(result)){continue;}
                    queue.add(result);
                    set.add(result);
                }      
                queue.remove();
            }
            steps++;
        }
        return 0; 
    }
}
