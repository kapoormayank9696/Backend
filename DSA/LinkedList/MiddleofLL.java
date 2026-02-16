public class MiddleofLL {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    public void insert(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
        }else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
    public void middle(){
        Node fast=head;
        Node slow=head;
        while(fast!= null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        System.out.println("Middle Element Of Linked List : "+slow.data);
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args){
        MiddleofLL list = new MiddleofLL();
        list.insert(2);
        list.insert(0);
        list.insert(90);
        list.insert(3);
        list.insert(35);
        list.insert(-3);
        list.display();
        list.middle();
    }
}
