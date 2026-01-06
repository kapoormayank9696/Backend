public class Mergetwosortedarray {
    public static void main(String[] args) {
        int[] arr1={1,3,5,7};
        int n=arr1.length;
        int[] arr2={2,4,6,8};
        int m=arr2.length;
        System.out.println("First Sorted Array Print");
        printArray(arr1,arr2);
        System.out.println("After Merging two Sorted Array");
        int k =MergeSortedArray(arr1, n, arr2, m);
        for(int i=0;i<k;i++){
            System.out.print(arr1[i]+" ");
        }
    }   
    public static void printArray(int[] arr1,int[] arr2){
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
        System.out.println("Second Sorted Array Print");
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();
    }
    public static int MergeSortedArray(int[] arr1,int n,int[] arr2,int m){
        int p=n-1;
        int q=m-1;
        int r=n+m-1;
        arr1=new int[n+m];
        while (p>=0 && q>=0) { 
            if(arr1[p] > arr2[q]){
            arr1[r]=arr1[p];
            r--;
            p--;
            }else{
                arr1[r]=arr2[q];
                r--;
                q--;
            }
        }
        while(p>=0){
                arr1[r]=arr1[p];
                r--;
                p--;
            }
        while(q>=0){
            arr1[r]=arr2[q];
            r--;
            q--;
            }
            return r;
        }
}

