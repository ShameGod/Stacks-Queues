class MyCircularQueue {
    
    private int[] data;
    private int p_head=0; // inizialize the head
    private int p_tail=0; // inizialize the tail
    public MyCircularQueue(int k) {
        //private List<Integer> data = Arrays.asList(new Integer[k]); 
        int[] data = new int[k]; // initialize fix sized array    
    }
    
    public boolean enQueue(int value) {
        if(isFull()){return false;}
        data[p_tail]=value;
        if(p_tail==data.length){
            p_tail = data[0];
        }else{
            p_tail = p_tail+1;
        }
        return true;
    }
    
    public boolean deQueue() {
        return true;
    }
    
    public int Front() {
        return 0;
    }
    
    public int Rear() {
        return 0;
    }
    
    public boolean isEmpty() {
        return this.data.length==0;
    }
    
    public boolean isFull() {
        return p_head==p_tail && !(p_tail==0 && p_head==0);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
