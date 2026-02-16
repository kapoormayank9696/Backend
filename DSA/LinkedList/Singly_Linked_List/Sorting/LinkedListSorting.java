// Implemtation of Singly Linked List Sorting By Bubble Sort
import java.util.Scanner;

public class LinkedListSorting{
    // Node class to represent each element in the Singly Linked List 
    class Node{
        // Default Access Modifier and Data Members
        int data;
        Node next;
        // Parameterized Constructor
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    // Insert An Elements
    public void insert(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }

    //Sorting the Linked List using Bubble Sort
    public void bubbleSort(){
        if(head==null || head.next==null){
            return;
        }
        boolean swapped;
        do{
            swapped=false;
            Node current=head;
            while(current.next!=null){
                if(current.data > current.next.data){
                    int temp=current.data;
                    current.data=current.next.data;
                    current.next.data=temp;
                    swapped=true;
                }
                current=current.next;
            }
        }while(swapped);
        }
        // Display Function of Singly Linked List
        public void display(){
        if(head==null){
            System.out.println("Empty List");
        }else{
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println("null");
        }
    }

    // Main function
    public static void main(String[] args) {
        LinkedListSorting list=new LinkedListSorting();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n=sc.nextInt();
        System.out.print("Enter Elements: ");
        for(int i=0;i<n;i++){
            int value=sc.nextInt();
            list.insert(value);
        }
        System.out.print("Original List:");
        list.display();
        list.bubbleSort();
        System.out.print("Sorted List:");
        list.display();
    }
}