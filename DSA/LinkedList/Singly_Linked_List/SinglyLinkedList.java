// Java Demonstrate The Singly Linked List
public class SinglyLinkedList {
    // Node class to represent each element in the Singly Linked List
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }    
    Node head = null;
    public void insert(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
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
    public void insertatbeging(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }
    public void insertatend(int val){
        Node newNode = new Node(val);
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
    public void insertatspecificposition(int val,int pos){
        Node newNode = new Node(val);
        if(pos < 0){
            System.out.println("Invalid position");
            return;
        }
        if (pos==0) {
            newNode.next=head;
            head=newNode;
        }else{
            Node temp = head;
            int count=1;
            while(temp.next != null){
                if(count == pos){
                    newNode.next=temp.next;
                    temp.next=newNode;
                }
                count++;
                temp = temp.next;
            }
        }
    }
    public void delete(){
        if(head == null){
            System.out.println("Empty linked list");
        }else{
            head = head.next;
        }
    }
    public void deleteAtEnd(){
        if(head == null){
            System.out.println("empty Linked list");
        }else{
            Node temp = head;
            while(temp.next != null){
                if(temp.next.next == null){
                    temp.next = null;
                    return;
                }
                temp = temp.next;
            }
        }
    }
    // Delete from Specific Position
    public void deleteAtSpecific(int index){
        if(index<0){
            System.out.println("Invalid Position!!!");
        }else if (index==0) {
            head=head.next;
        }else{
            int count=1;
            Node temp=head;
            while(temp.next!=null){
                if(count == index){
                    temp.next=temp.next.next;
                    return;
                }
                temp=temp.next;
                count++;
            }
        }
    }
    // Function to Update At Beginning
    public void UpdateAtBeginning(int value){
        if(head == null){
            System.out.println("Empty Linked List!!!");
        }else{
            head.data = value;
        }
    }
    // Function to Update At End
    public void UpdateAtEnd(int value){
        if(head == null){
            System.out.println("Empty Singly Linked List!!!");
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.data = value;
        }
    }
    // Function to Update At Specific
    public void UpdateAtSpecific(int index,int value){
        if(index<0){
            System.out.println("Empty Singly Linked List!!!");
        }else if(index==0){
            head.data=value;
        }else{
            int count=1;
            Node temp = head;
            while(temp.next != null){
                if(count==index){
                    temp.data = value;
                }
                temp = temp.next;
                count++;
            }
        }
    }
    public void display(){
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+"--> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Original Singly Linked List: ");
        // Insert values in the singly linked list
        list.insert(2);
        list.insert(5);
        list.insert(10);
        list.insert(90);

        // Display the Linked List
        list.display();

        System.out.print("After Insert Element At Beginng: ");
        // Insert at the beginning
        list.insertatbeging(85);
        list.display();

        System.out.print("After Insert Element At End: ");
        // Insert at end
        list.insertatend(58);
        list.display();

        System.out.print("After Insert At Specific Position: ");
        // Insert at specific position
        list.insertatspecificposition(34, 2);
        list.display();
        list.display();

        System.out.print("After Delet from beginng: ");
        // Delete first element
        list.delete();
        list.display();

        System.out.print("After delete from end: ");
        // Delete last element
        list.deleteAtEnd();
        list.display();
        
        System.out.print("After delete from specific position: ");
        // Delete From Specific Position
        list.deleteAtSpecific(3);
        list.display();
        
        System.out.print("Update First element : ");
        // Update From Beginning Value
        list.UpdateAtBeginning(43);
        list.display();
        // Update From End Value
        System.out.print("Update Last element : ");
        list.UpdateAtEnd(86);
        list.display();
        // Update From Specific Value
        System.out.print("Update Specific Position element : ");
        list.UpdateAtSpecific(3, 24);
        list.display();
    }
}
