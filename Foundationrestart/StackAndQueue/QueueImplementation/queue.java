public class queue {
    protected int[] arr = null;
    protected int capacity = 0; // maximum element that array can hold in it.
    protected int elementCount = 0; // No of elements present in stack.
    protected int foq=0;
    protected int roq = -1;

    // constructor.=============================================

    protected void intializeVariables(int capacity) {
        this.capacity = capacity;
        this.arr = new int[this.capacity];
        this.elementCount = 0;
        this.foq = -1;
        this.roq = -1;
    }

    public queue() {
        intializeVariables(10); // default capacity.
    }

    public queue(int size) {
        intializeVariables(size);
    }

    // basic Function.=========================================

    public int size() {
        return this.elementCount;
    }

    public boolean isEmpty() {
        return this.elementCount == 0;
    }

    public void display() {

    }

    // Exceptions.=============================================

    private void OverflowException() throws Exception {
        if (this.capacity == this.elementCount) {
            throw new Exception("QueueIsFull");
        }
    }

    private void underFlowException() throws Exception {
        if (this.elementCount == 0) {
            throw new Exception("QueueIsEmpty");
        }
    }

    // stack functions=========================================
    protected void push_(int data) {
        if(this.foq == -1){
            foq++;
        }
        this.arr[++this.roq] = data;
        this.elementCount++;
    }

    public void push(int data) throws Exception {
        OverflowException();
        push_(data);
    }

    public int front() throws Exception {
        underFlowException();
        return this.arr[this.foq];
    }

    protected int pop_() {
        int rv = this.arr[this.foq];
        this.arr[this.foq++] = 0;
        this.elementCount--;
        return rv;
    }

    public int pop() throws Exception {
        underFlowException();
        return pop_();
    }
}