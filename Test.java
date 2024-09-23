public class Test {

    public static void selection_Sort(int[] arr){
        int n = arr.length;
        for(int i = 0; i< n-1; i++){
            int min_index = i;
            for(int j = i+1; j<n ; j++){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
        for (int i : arr) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }
//-------------------------------------------------------------------------
    public static void insertion_Sort(int[] A){
        int n = A.length;
        for(int i = 1; i< n; i++){
            int hole = i;
            int key = A[hole];
            for(int j = 0; j< n-1; j++){
                if(hole > 0 && A[hole-1] > key){
                    A[hole] = A[hole-1];
                    hole --;
                }
            }
            A[hole] = key;
        }
        for (int i : A) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }
//---------------------------------------------------------------------------
    public static void bubble_Sort(int[] A){
        int n = A.length;
        for(int i = 0; i< n-1; i++){
            for(int j = 0; j< n-1-i; j++){
                if(A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        for (int i : A) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }
//-------------------------------------------------------------------------
    public static int[] merge(int[]L, int[]R, int[] A){
        int nL = L.length;
        int nR = R.length;
        int i = 0, j= 0, k=0;
        
        while(i< nL && j < nR){
            if(L[i] <= R[j]){
                A[k] = L[i];
                i++; k++;
            }
            else{
                A[k] = R[j];
                j++; k++;
            }
            
        }
        while(i < nL){
            A[k] = L[i];
            i++; k++;
        }
        while(j<nR){
            A[k]= R[j];
            j++; k++;
        }
        return A;
    }

    public static int[] merge_Sort(int[] A){
        int n = A.length;
        if(n<2){
            return A;
        }
        int mid = n/2;
        int[] L = new int[mid];
        int[] R = new int[n-mid];

        for(int i=0; i< mid; i++){
            L[i] = A[i];
        }
        for(int j = mid; j< n;j++) {
            R[j-mid] = A[j];
        }

        L = merge_Sort(L);
        R = merge_Sort(R);
        merge(L, R, A);
        return A;
    }
//----------------------------------------------------------------------------------
    public static int partition(int[] A, int start, int end){
        
        int pivot = A[end]; 
        int p_index = start;

        for(int i = start; i<= end-1; i++){
            if(A[i] <= pivot){
                int temp1 = A[i];
                A[i] = A[p_index];
                A[p_index] = temp1;
                p_index++;
            }
        }
        int temp2 = A[p_index];
        A[p_index] = A[end];
        A[end] = temp2;

        return p_index;
    }
    public static int[] quick_Sort(int[] A, int start, int end){
        if (start < end)
        {
            int p_index = partition(A, start, end);
            quick_Sort(A, start,p_index-1);
            quick_Sort(A, p_index+1, end);
        }
        return A;
    }

    public static void main(String[] args) {
        int[] array = {3,9,4,6,1,7,8,2,5};
        //selection_Sort(array);
        //insertion_Sort(array);
        //bubble_Sort(array);
        //merge_Sort(array);
        quick_Sort(array, 0, array.length-1);
        for(int i: array){
            System.out.print(i + " ");
        }
        System.out.println();
        
    }
}
