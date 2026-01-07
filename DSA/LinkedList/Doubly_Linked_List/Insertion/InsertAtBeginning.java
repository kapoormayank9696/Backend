// Doubly Linked List Implementation In Java And Insert Element At Beginning Position
import java.util.Scanner;

public class InsertAtBeginning {
    class Node{
        // Default Access Modifier and Data Members
        int data;
        Node next;
        // Constructor
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    Node tail=null;
    
    // Function To Insert The Element In doubly Linked List
    public void insert(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
    }

    // Function To Insert The Element In Doubly Linked List At Beginning
    public void insertAtBeginning(int value){
        Node newNode=new Node(value);
        if(head==null){
            head=newNode;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
    }

    // Function To Display The Linked List
    public void display(){
        if(head==null){
            System.out.println("Empty Doubly Linked List!!!");
        }else{
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+"<-->");
                temp=temp.next;
            }
            System.out.println("null");
            System.out.println();
        }
    }

    // Main function
    public static void main(String[] args) {
        InsertAtBeginning list=new InsertAtBeginning();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n=sc.nextInt();
        System.out.print("Enter Elements: ");
        for(int i=0;i<n;i++){
            int value=sc.nextInt();
            list.insert(value);
        }
        System.out.print("After Insert Element In Doubly Linked List: ");

        // Display the Linked List 
        list.display();
        
        System.out.print("Enter Element Insert At Beginning: ");
        int value=sc.nextInt();
        System.out.print("After Inserting the Element At Beginning Of Doubly Linked List: ");
        // Call the function to insert the element at beginning of linked list
        list.insertAtBeginning(value);
        list.display();

    }
}
