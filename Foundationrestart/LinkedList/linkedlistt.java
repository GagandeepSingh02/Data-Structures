public class linkedlistt{

    private class Node{
        int data = 0 ;
        Node next = null;
        Node(int data){
            this.data = data;
        }
    }
    private Node head = null;
    private Node tail = null;
    private int sizeOfLL = 0;

    public boolean isEmpty(){
        return this.sizeOfLL == 0;
    }
    public int size(){
        return this.sizeOfLL;
    }
    public void display(){
        Node curr = this.head;
        while(curr != null){
            System.out.print(curr.data + "->");
            curr=curr.next;
        }
        System.out.println();
    }

    //Exceptions
    private void EmptyException() throws Exception {
        if(this.sizeOfLL == 0){
            throw new Exception("LinkedList is empty : -1");
        }
    }

    private void IndexOutOfBoundSizeExclusiveException(int idx) throws Exception{
         if(idx < 0 || idx >= this.sizeOfLL){
             throw new Exception("Index out of Bound: -1");
         }
    }

     private void IndexOutOfBoundSizeInclusiveException(int idx) throws Exception{
         if(idx < 0 || idx > this.sizeOfLL){
             throw new Exception("Index out of Bound: -1");
         }
    }

    //Get========================================================================================================================

    public int getFirst() throws Exception{
         EmptyException();
         return this.head.data;
    }

    public int getLast() throws Exception{
         EmptyException();
         return this.tail.data;
    }

    private Node getNodeAt(int idx){
        Node curr = this.head;
        while(idx-- > 0){
            curr=curr.next;
        }
          
        return curr;
    }

    public int getAt(int idx) throws Exception{
        IndexOutOfBoundSizeExclusiveException(idx);
        Node node = getNodeAt(idx);
        return node.data;
    }
    
    //ADD=================================================================================================================================

    private void addFirstNode(Node node){
        if(this.head== null){
            this.head = node;
            this.tail = node;
        }else{
            node.next = this.head;
            this.head = node;
        }

        this.sizeOfLL++;
    }

    public void addFirst(int data){
        Node node = new Node(data);
        addFirstNode(node);
    }

    private void addLastNode(Node node){
        if(this.head== null){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next=node;
            this.tail=node;
        }

        this.sizeOfLL++;
    }

    public void addLast(int data){
        Node node = new Node(data);
        addLastNode(node);
    }

    private void addAtNode(Node node , int idx){
        if( idx == 0 ) addFirstNode(node);
        else if(idx == this.sizeOfLL) addLastNode(node);
        else{
            Node prev =getNodeAt(idx-1);
            Node forw = prev.next;
            
            node.next = forw;
            prev.next=node;

            this.sizeOfLL++;
        }
    }

    public void addAt(int data , int idx) throws Exception{
        IndexOutOfBoundSizeInclusiveException(idx);
        Node node = new Node(data);
        addAtNode(node , idx);
}

// Remove=================================================================================================

    private Node removeFirstNode(){
        Node removeNode=this.head;
        if(this.sizeOfLL == 1){
           this.head=null;
           this.tail=null;
        }else{
            Node forw = removeNode.next;
            removeNode.next=null;
            this.head=forw;

        }
        
        this.sizeOfLL --;
        return removeNode;  
    }

    public int removeFirst() throws Exception{
        EmptyException();
        Node node = removeFirstNode();
        return node.data;
    }

    private Node removeLastNode(){
        Node removeNode=this.tail;
        if(this.sizeOfLL == 1){
           this.head=null;
           this.tail=null;
        }else{
          Node secondLastNode = getNodeAt(this.sizeOfLL-2);
          this.tail=secondLastNode;
          this.tail.next=null;

        }
        
        this.sizeOfLL --;
        return removeNode;  
    }

    public int removeLast() throws Exception{
        EmptyException();
        Node node = removeLastNode();
        return node.data;
    }

    private Node removeAtNode(int idx){
        if(idx == 0) return removeFirstNode();
        else if(idx == this.sizeOfLL-1) return removeLastNode();
        else{
            Node prev = getNodeAt(idx-1);
            Node curr = prev.next;
            Node forw = curr.next;

            prev.next=forw;
            curr.next=null;
            
            this.sizeOfLL--;
            return curr;

        }
         
    }

    public int removeAt(int idx) throws Exception{
        IndexOutOfBoundSizeInclusiveException(idx);
        Node node = removeAtNode(idx);
        return node.data;
    }
}

