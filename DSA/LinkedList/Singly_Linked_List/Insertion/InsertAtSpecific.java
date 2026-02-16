// Singly Linked List Implementation in Java

import java.util.Scanner;

public class InsertAtSpecific {

    // Node class to represent each element in the Singly Linked List
    class Node{

        // Default Access Modifier and Data Members
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

    // Function to Insert At Specific Position
    public void insertAtSpecific(int index, int data){
        Node newNode = new Node(data);
         if(index < 0){
            System.out.println("Invalid position");
        }
        else if(index==0)
            {
                head=newNode;
            }else{
                Node temp = head;
                int count=1;
                while(temp.next != null){
                    if(count == index-1){
                        newNode.next=temp.next;
                        temp.next=newNode;
                    }
                    count++;
                    temp = temp.next;
                }
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

    // Main function
    public static void main(String[] args) {

        // Call the class of insert elements at specific of singly linked list
        InsertAtSpecific list = new InsertAtSpecific();
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

        // Insert At Specific Position
        System.out.print("Enter Index: ");
        int index=sc.nextInt();
        System.out.print("Enter value: ");
        int value=sc.nextInt();
        list.insertAtSpecific(index,value);
        System.out.print("After Insert At specific position In Singly Linked List: ");
        
        // Display the Linked List 
        list.display();
    }
}
