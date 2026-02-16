package dsa.Sorting;
public class Insertionsort {
    public static void main(String[] args) {
        int[] arr={64,34,25,12,22,11,90};
        System.out.println("Before Sorting an array");
        printArray(arr);
        System.out.println("After Sorting an Array Using Insertion Sort");
        Insertionsort(arr);
        printArray(arr);
    }
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void Insertionsort(int[] arr){
        int n=arr.length;
        for(int i=1;i<n-1;i++){
            int k=arr[i];
            int j=i-1;
            while(j > 0 && k < arr[j]){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=k;
        }
    }
}
