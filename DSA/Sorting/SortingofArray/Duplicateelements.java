// When Array is Ajacent sorted In The Array Then This Code Works Fine
import java.util.Arrays;

public class Duplicateelements {
    public static void main(String[] args) {
        int[] arr={12,34,12,45,67,34,89,90,45};
        System.out.println("Array elements are : ");
        printArray(arr);
        System.out.println("After removing duplicate elements from array : ");
        //Sort The Array First
        Arrays.sort(arr);
        int k=removeDuplicate(arr);
        //Print sorted Array without duplicate elements
        for(int i=0;i<k;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static int removeDuplicate(int[] arr){
        int n=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                arr[n]=arr[i];
                n++;
            }
        }
        return n;
    }
}
