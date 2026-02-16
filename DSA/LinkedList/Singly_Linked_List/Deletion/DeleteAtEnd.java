// Singly Linked List Implementation in Java 

import java.util.Scanner;

public class DeleteAtEnd {

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

    // Insert Elements in Linked List
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

    // Delete from end
    public void deleteAtEnd(){
        if(head == null){
            System.out.println("Empty linked list");
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
                if(temp.next.next == null){
                    temp.next = null;
                    return;
                }
            }
        }
    }

    // Display Linked List
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
        DeleteAtEnd list = new DeleteAtEnd();
        
        // Insert the elements in Linked List
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

        // Delete from end
        System.out.print("After deleting from end : ");
        list.deleteAtEnd();

        // Display the Linked List 
        list.display();
    }
}

