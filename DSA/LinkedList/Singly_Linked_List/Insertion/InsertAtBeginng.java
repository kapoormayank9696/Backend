// Singly Linked List Implementation in Java

// Time Complexity O(1)

import java.util.Scanner;

public class InsertAtBeginng {

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

    // Function to Insert At Beginning
    public void InsertAtBeginning(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
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
            System.out.println();
        }
    }

    // Main function
    public static void main(String[] args) {

        // Call the class of insert elements at beginng of singly linked list
        InsertAtBeginng list = new InsertAtBeginng();
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

        // Insert At Begining
        System.out.print("Enter value: ");
        int value=sc.nextInt();
        list.InsertAtBeginning(value);
        System.out.print("After Insert At Beginning In Singly Linked List: ");
        
        // Display the Linked List 
        list.display();
    }
}
