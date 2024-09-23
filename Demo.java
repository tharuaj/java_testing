
import java.util.Arrays;

class Calculator
{
    public int add(int n1, int n2)
    {
        return n1 + n2;
    }
}



public class Demo {

    //Selection Sort
    private static int[] selection_sort(int array[])
    {
        
        int len = array.length;
        for (int i = 0; i < len -1;  i++)
        {
            int min_index = i;

            for (int j = i+1; j < len;  j++)
            {
                if (array[j] < array[min_index])
                {
                    min_index = j;
                }
            }
            
            int temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;
        }
        return array;

    }

    //Insertion Sort
    public static int[] insertion_sort(int array[])
    {
        
        int length = array.length;

        for (int i = 1; i<length;i++)
        {
            int key = array[i];
            int hole  = i;

            while( hole > 0 &&  array[hole - 1] > key)
            {
                array[hole] = array[hole-1];
                hole --;
            }
            array[hole] = key;
        }
        return array;
    }

    //Bubble Sort
    public static int[] bubble_sort(int array[]){
        
        int length = array.length;
        
        for (int i = 0; i < length-1; i++)
        {
            for (int j = 0; j< length-1-i; j++)
            {
                if (array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
// Merge Sort
    public static int[] merge_sort(int array[])
    {
        
        int len = array.length;
        if (len <2)
        {
            return array;
        }
        int mid = len/2;
        int array_L [];
        int array_R [];
        array_L = new int[mid];
        array_R = new int[len-mid];

        for (int i = 0; i<mid; i++)
        {
            array_L[i] = array[i];
        }
        for (int i = mid; i<len; i++)
        {
            array_R[i-mid] = array[i];
        }

        array_L = merge_sort(array_L);
        array_R = merge_sort(array_R);
        merge(array_L, array_R, array);

        return array;
    }

    public static int[] merge(int array_L[], int array_R[], int array[])
    {
        int nL = array_L.length;
        int nR = array_R.length;
        int i = 0; int j =0; int k = 0;

        while (i < nL && j < nR)
        {
            if(array_L[i] <= array_R[j])
            {
                array[k] = array_L[i];
                i++;

            }
            else
            {
                array[k] = array_R[j];
                j++;
                
            }
            k++;
        }
        //After upper block one of the arrays will be done
        //and now the remaining array will be merged
        while(i < nL)
        {
            array[k] = array_L[i];
            i++;
            k++;
        }
        while(j < nR)
        {
            array[k] = array_R[j];
            j++;
            k++;
        }
        return array;

    }


    public static int partition(int A[], int start, int end)
    {
        int pivot  = A[end];
        int p_index = start;
        for (int i = start; i<= end-1 ;i++)
        {
            if (A[i] <= pivot)
            {
                
                int temp = A[i];
                A[i] = A[p_index];
                A[p_index] = temp;
                p_index++;
            }
        }
        int temp = A[p_index];
        A[p_index] = A[end];
        A[end] = temp;
        return p_index;
    }

    public static int[] quicksort(int A[],int start, int end)
    {
        
        if (start < end)
        {
            int p_index = partition(A, start, end);
            quicksort(A, start, p_index-1);
            quicksort(A, p_index+1, end);
        }

        return A;
        
    }

    public static void main(String[] args) {
        int num1 = 7;
        int num2 = 2;
        Calculator calc1 = new Calculator();
        int sum = calc1.add(num1, num2);
        System.out.println("The sum is: "+ sum);

        int arr[] = { 3,45,9,18,57,66,23};
        

        System.out.println("Unsorted array: "+ Arrays.toString(arr));

        int [] sorted_selection= selection_sort(arr);
        System.out.println("Sorted_Selection array: "+  Arrays.toString(sorted_selection));

        int [] sorted_insertion =  insertion_sort(arr);
        System.out.println("Sorted_Insertion array: "+  Arrays.toString(sorted_insertion));

        int [] sorted_bubble = bubble_sort(arr);
        System.out.println("Sorted_Bubble array: "+  Arrays.toString(sorted_bubble));

        int[] sorted_merge = merge_sort(arr);
        System.out.println("Sorted_Merge array: "+ Arrays.toString(sorted_merge));
        
        int[] sorted_quick = quicksort(arr, 0, arr.length-1);
        System.out.println("Sorted_Quick array: "+ Arrays.toString(sorted_quick));
        
        
        
    }
}
