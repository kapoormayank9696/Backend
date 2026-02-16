public class ReverseofLL {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    public void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public void display(){
        if(head == null){
            System.out.println("Empty Linked List");
        }else{
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.print("null\n");
        }
    }
    public void reverse(){
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    public static void main(String[] args) {
        ReverseofLL list = new ReverseofLL();
        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(18);
        list.insert(21);
        list.display();
        list.reverse();
        list.display();
    }
}
