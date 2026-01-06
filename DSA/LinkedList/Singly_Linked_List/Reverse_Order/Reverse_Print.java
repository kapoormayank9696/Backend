// Singly Linked List Implementation in Java and print in reverse order
// Time complexity O(1) and space complexity O(1)
import java.util.Scanner;

public class Reverse_Print {

    // Node class to represent each element in the singly Linked List
    class Node{

        // Default Access Modifier and Data Members
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;

    // Function to Insert In Singly Linked List Value
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

    // Display Linked List Function
    public void display(){
        if(head == null){
            System.out.println("Empty Linked List");
        }else{
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data+"-->");
                temp=temp.next;
            }
            System.out.print("null\n");
        }
    }

    // Function to Reverse Linked List
    public void reverse(){
        Node prev = null;
        Node current = head;
        Node next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Main function
    public static void main(String[] args) {

        // Call the class of reverse print
        Reverse_Print list = new Reverse_Print();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n=sc.nextInt();
        System.out.print("Enter Elements: ");
        for(int i=0;i<n;i++){
            int value=sc.nextInt();
            list.insert(value);
        }
        System.out.print("Original Singly Linked List Display: ");

        // Display the Linked List 
        list.display();
        System.out.print("Reversed Singly Linked List: ");
        list.reverse();
        
        // Display the Linked List 
        list.display();
    }
}
