// Doubly Linked List Implementation In Java And Insert Element At End Position

import java.util.Scanner;

public class InsertAtEnd {
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
        InsertAtEnd list=new InsertAtEnd();
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

        System.out.print("Enter Element Insert At End: ");
        int end=sc.nextInt();
        System.out.print("After Inserting the Element At End Of Doubly Linked List: ");
        // Call the function to insert the element at last of linked list
        list.insert(end);
        list.display();
    }
}
