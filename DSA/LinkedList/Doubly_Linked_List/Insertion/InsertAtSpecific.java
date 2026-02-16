// Doubly Linked List Implementation In Java And Insert Element At Specific Position

import java.util.Scanner;

public class InsertAtSpecific {
    
    class Node{
        int data;
        Node prev;
        Node next;
        // Constructor
        public Node(int data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }
    Node head=null;
    Node tail=null;

    // Insert The Element In Doubly Linked list
    public void insert(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            newNode.prev = tail;
            tail=newNode;
        }
    }

    // Function to Insert At Specific Position
    public void insertAtSpecific(int index, int data){
        Node newNode = new Node(data);
        if(index < 0){
            System.out.println("Invalid position");
        }else if(index==0){
            newNode.next=head;
            if(head!=null)
                head.prev=newNode;
            head=newNode;
        }else{
            Node temp = head;
            int count=1;
            while(temp!= null){
                if(count == index-1){
                    newNode.next=temp.next;
                    newNode.prev=temp;
                    if(temp.next!=null){
                        temp.next.prev=newNode;
                    }else{
                        tail=newNode;
                    }
                    temp.next=newNode;
                    return;
                }
                count++;
                temp = temp.next;
            }
        }
    }
    
    // Display Function Of Doubly Linked List
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
        InsertAtSpecific list=new InsertAtSpecific();
        System.out.print("Enter number of terms: ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print("Enter Elements: ");
        for(int i=0;i<n;i++){
            int value=sc.nextInt();
            list.insert(value);
        }
        System.out.print("Original Doubly Linked List: ");
        // Call The Function To Print Doubly Linked List
        list.display();
        System.out.print("Enter Index: ");
        int index=sc.nextInt();
        System.out.print("Enter Element Insert At Specific Postion: ");
        int value=sc.nextInt();
        System.out.print("After Inserting the Element At Specific Position Of Doubly Linked List: ");
        list.insertAtSpecific(index,value);
        // Call The Function To Print Doubly Linked List
        list.display();
    }
}
