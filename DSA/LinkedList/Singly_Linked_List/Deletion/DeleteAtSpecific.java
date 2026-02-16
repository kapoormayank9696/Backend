// Singly Linked List Implementation in Java 

import java.util.Scanner;

public class DeleteAtSpecific {
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
                if(count == index-1){
                    temp.next=temp.next.next;
                    return;
                }
                temp=temp.next;
                count++;
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
        DeleteAtSpecific list = new DeleteAtSpecific();
        
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

        // Delete from Specific Position
        System.out.print("Enter Index: ");
        int index=sc.nextInt();
        list.deleteAtSpecific(index);
        System.out.print("After deleting from Specific Position : ");

        // Display the Linked List 
        list.display();
    }
}

