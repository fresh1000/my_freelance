
public class Queue {
	private int[] queue;
	private int maxSize;
	private int nElem;
	private int front;
	private int rear;
	
	public Queue (int maxSize) {
		this.maxSize = maxSize;
		queue = new int[maxSize];
		nElem = 0;
		front = 0;
		rear = -1;
	}
	
	public void insert (int elem) {
		if (rear == maxSize - 1){
			rear = -1;
		}
		queue[++rear] = elem;
		nElem++;
	}
	
	public int remove () {
		int temp = queue[front++];
		if (front ==maxSize){
				front = 0;
		}
		nElem--;
		return temp;
	}
	
	public int getFront() {
	    return queue[front];
	}
	 
	public int getRear() {
	    return queue[rear];
	}
	 
	public boolean isFull() {
	    return (nElem == maxSize - 1);
	}
	 
	public boolean isEmpty() {
	    return (nElem == 0);
	}
	 
	public int getSize() {
	    return nElem;
	}

}
