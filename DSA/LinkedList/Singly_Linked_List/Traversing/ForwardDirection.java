// Java Demonstrate Print The Singly Linked List In Forward Direction
public class ForwardDirection {
    // Node class to represent each element in the Singly Linked List
    class Node{
        // Default Access Modifier and Data Members
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }    
    Node head = null;
    // Function To Insert In Singly Linked List Value
    public void Insert(int data){
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    // Display Linked List Function
    public void display(){
        if(head==null){
            System.out.println("Empty Singly Linked List!!");
        }else{
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+"-->");
                temp=temp.next;
            }
            System.out.println("null");
        }
    }
    // Display Linked List In Forward DirectionFunction
    public void forwardDirection(){
        if(head==null){
            System.out.println("Empty Singly Linked List!!");
        }else{
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+"-->");
                temp=temp.next;
            }
            System.out.println("null");
        }
    }

    // Main function
    public static void main(String[] args) {

        // Call the class of Forward Direction 
        ForwardDirection list = new ForwardDirection();
        System.out.print("After Insert Element In Singly Linked List: ");
        list.Insert(7);
        list.Insert(-2);
        list.Insert(0);
        list.Insert(89);
        list.Insert(35);
        list.Insert(-96);
        list.Insert(1);
        list.Insert(0);

        // Display the Linked List 
        list.display();

        // Forward Direction Traversal
        System.out.print("Traversing Singly Linked List In Forward Direction: ");
        list.forwardDirection();
        
        // Display the Linked List 
        list.display();
    }
}

