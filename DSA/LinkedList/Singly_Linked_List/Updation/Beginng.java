// Singly Linked List Implementation in Java

// Time Complexity O(1)
public class Beginng {

    // Node class to represent each element in the Singly Linked List
    class Node{

        // Default Access Modifier and Data Member
        int data; 
        Node next;

        // Parameterized Constructor
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

    // Function to Update At Beginning
    public void UpdateAtBeginning(int value){
        if(head == null){
            System.out.println("Empty Linked List!!!");
        }else{
            head.data = value;
        }
    }

    // Display Linked List Function
    public void display(){
        if(head==null){
            System.out.println("Empty Singly Linked List!!!");
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

        // Call the class of insert elements at beginng of singly linked list
        Beginng list = new Beginng();
        System.out.print("After Insert Element In Singly Linked List: ");
        list.Insert(7);
        list.Insert(-2);
        list.Insert(0);
        list.Insert(89);
        list.Insert(35);
        list.Insert(6);
        list.Insert(1);
        list.Insert(0);

        // Display the Linked List 
        list.display();

        // Update At Begining
        System.out.print("After Update At Beginning In Singly Linked List: ");
        list.UpdateAtBeginning(56);
        
        // Display the Linked List 
        list.display();
    }
}