public class SumofLL {
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
        }
        else{
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
        }
        else{
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.print("null\n");
        }
    }
    public void sum(){
        int sum = 0;
        Node temp = head;
        while(temp != null){
            sum = sum +temp.data;
            temp = temp.next;
        }
        System.out.println("Sum of Linked List is : "+sum);
    }
    public static void main(String[] args) {
        SumofLL list = new SumofLL();
        list.insert(2);
        list.insert(5);
        list.insert(10);
        list.insert(13);
        list.insert(17);
        list.insert(23);
        list.insert(37);
        list.display();
        list.sum();
    }
}
