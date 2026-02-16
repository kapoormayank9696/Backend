public class UpdationLL {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    public void insert(int data){
        Node newNode= new Node(data);
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
    public void update(int position,int newData){
        if(head==null){
            System.out.println("List is empty");
        }else{
            Node temp=head;
            int count=0;
            while(temp!=null){
                if(count==position){
                    temp.data=newData;
                }
                temp=temp.next;
                count++;
            }
        }
    }
    public void display(){
        if (head==null) {
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
    public static void main(String[] args) {
        UpdationLL list=new UpdationLL();
        System.out.print("Before updation:");
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display();
        System.out.print("After updation:");
        list.update(1,25);
        list.display();
    }
}
