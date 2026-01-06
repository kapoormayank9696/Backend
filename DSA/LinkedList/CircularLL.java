public class CircularLL{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    Node tail=null;
    public void insert(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            tail.next=head;
        }else{
            tail.next=newNode;
            tail=newNode;
            tail.next=head;
        }
    }
    public void display(){
        Node temp=head;
        do{
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        while(temp != head);
        System.out.println("Back to head <->"+head.data);
    } 
    public static void main(String[] args){
        CircularLL list = new CircularLL();
        list.insert(5);
        list.insert(23);
        list.insert(33);
        list.insert(40);
        list.insert(50);
        list.insert(60);
        list.display();
    }
}

