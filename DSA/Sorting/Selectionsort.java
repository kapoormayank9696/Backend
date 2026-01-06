public class Selectionsort {
    public static void main(String[] args) {
        int[] arr={64,34,25,12,22,11,90};
        System.out.println("Before Sorting An Array");
        printArray(arr);
        System.out.println("After Sorting An Array Using Selection Sort");
        Selectionsort(arr);
        printArray(arr);
    }    
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void Selectionsort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int minIndex=i;
            for(int j=i+1;j<n;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex=j;
                }
            }
            int c=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=c;
        }
    }
}
