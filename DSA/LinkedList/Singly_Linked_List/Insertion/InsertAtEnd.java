// Singly Linked List Implementation in Java
// Time Complexity O(n)

import java.util.Scanner;

public class InsertAtEnd {

    // Node class to represent each element in the Singly Linked List
    class Node{

        // Default Access modifer and Data Members
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
    public void insert(int data){
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

    // Function to Insert At End
    public void insertAtEnd(int data){
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
                System.out.println();
            }
        }

    // Main function
    public static void main(String[] args) {
        
        // Call the class of insert elements at end of singly linked list
        InsertAtEnd list = new InsertAtEnd();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n=sc.nextInt();
        System.out.print("Enter Elements: ");
        for(int i=0;i<n;i++){
            int value=sc.nextInt();
            list.insert(value);
        }
        System.out.print("After Insert Element In Singly Linked List: ");

        // Display the Linked List 
        list.display();

        // Insert At End
        System.out.print("Enter Value: ");
        int value=sc.nextInt();
        list.insertAtEnd(value);
        System.out.print("After Insert At end In Singly Linked List: ");

        // Display the Linked List 
        list.display();
    }
}

