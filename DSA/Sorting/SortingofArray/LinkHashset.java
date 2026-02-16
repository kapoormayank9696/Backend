// Remove Duplicate Element FRom Array Using LinkedHashSet
import java.util.LinkedHashSet;

public class LinkHashset{
    public static void main(String[] args) {
        int[] arr={10,20,10,30,40,20,50,60,50};
        System.out.println("Original Array with Duplicate Element");
        printArray(arr);
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int num:arr){
            set.add(num);
        }
        System.out.println("Array After Removing Duplicate Element Using LinkedHashSet");
        printArray(set);
    }
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void printArray(LinkedHashSet<Integer> set){
    for(int num:set){
        System.out.print(num+" ");
    }
    System.out.println();
}
}
