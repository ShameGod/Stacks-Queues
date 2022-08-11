class MyCircularQueue {
    public int arr[];
    public int front;
    public int next;
    public int currentSize;
    public int totalSize;
    public MyCircularQueue(int k) {
        arr = new int[k];
        front = -1;
        next = 0;
        totalSize = k;
        currentSize = 0;
    }
    
    public boolean enQueue(int value) {
        if(currentSize == totalSize){
            return false;
        }
        arr[next] = value;
        next = (next+1)%totalSize;
        if(front == -1) front = 0;
        currentSize++;
        return true;
    }
    
    public boolean deQueue() {
        if(currentSize==0) return false;
        front = (front+1)%totalSize;
        currentSize--;
        if(currentSize==0){
            front = -1;
            next = 0;
        }
        return true;
    }
    
    public int Front() {
        if(currentSize==0) return -1;
        return arr[front];
    }
    
    public int Rear() {
        if(currentSize==0) return -1;
        if(next == 0) return arr[totalSize-1];
        return arr[next-1];
    }
    
    public boolean isEmpty() {
        return currentSize==0;
    }
    
    public boolean isFull() {
        return currentSize==totalSize;
    }
}
