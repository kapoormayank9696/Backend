// Singly Linked List Searching Operation Implementation in Java
// Time complexity O(n) and space complexity O(1)
import java.util.Scanner;

public class SequentialSearch {
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
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }

    // Linear Search and return the position of target element
    public int linearsearch(int target){
        if(head==null){
            System.out.println("Empty linked list!!!");
        }else{
            Node temp=head;
            int count=1;
            while(temp!=null){
                if(temp.data == target){
                    return count;
                }
                temp=temp.next;
                count++;
            }
        }
        return -1;
    }
    // Display Function of Singly Linked List
    public void display(){
        if(head==null){
            System.out.println("Empty Linked List!!!");
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
        SequentialSearch list=new SequentialSearch();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n=sc.nextInt();
        System.out.print("Enter Elements: ");
        for(int i=0;i<n;i++){
            int value=sc.nextInt();
            list.insert(value);
        }

        System.out.print("Print The Singly linked list: ");
        // Display the singly linked list
        list.display();
        // Take user target element for searching from linked list
        System.out.print("Enter a target: ");
        int target=sc.nextInt();
        int result=list.linearsearch(target);
        if(result!=-1){
            System.out.println("Target element exist into the singly linked list at position: "+result);
        }
        else{
            System.out.println("Target element not exist in singly linked list!!!");
        }
    }
}
