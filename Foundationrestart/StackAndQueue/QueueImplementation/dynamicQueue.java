public class dynamicQueue extends stack {

    public dynamicQueue() {
        super();
    }

    public dynamicStack(int size) {
        super(size);
    }

    public dynamicQueue(int[] arr) {
        super.intializeVariables(arr.length);

        for (int ele : arr)
            super.push_(ele);
    }

    protected void push_(int data){
        if (super.capacity == super.elementCount) {
            int[] temp = super.arr; // copy old data
            super.intializeVariables(2 * super.capacity); // new space allocate for new upcoming data.
            for (int ele : temp) // copy old data in new space.
                super.push_(ele);
        }

        super.push_(data);
    }
    public void push (int data){
        push_(data);
    }
}