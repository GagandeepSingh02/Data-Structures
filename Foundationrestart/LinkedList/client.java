public class client{
    public static void main(String[] args) throws Exception{
        linkedlistt ll1 = new linkedlistt();
        for(int i=0;i<10;i++) ll1.addFirst(i * 10);

        linkedlistt ll2 = new linkedlistt();
        for(int i=0;i<10;i++) ll2.addFirst(i * 100);

        linkedlistt ll3 = new linkedlistt();
        for(int i=0;i<10;i++) ll3.addFirst(i * 1000);

        linkedlistt ll4 = new linkedlistt();
        for(int i=0;i<10;i++) ll4.addFirst(i * 20);
         
         ll1.display();
         ll1.removeAt(5);
         ll1.display();
    }
}