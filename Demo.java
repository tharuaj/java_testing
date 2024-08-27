import java.sql.Array;
import java.util.Arrays;

class Calculator
{
    public int add(int n1, int n2)
    {
        return n1 + n2;
    }
}



public class Demo {

    private static int[] selection_sort(int array[],int len)
    {

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
            hole = hole -1 ;
        }
        array[hole] = key;
    }
    return array;
}
    public static void main(String[] args) {
        int num1 = 7;
        int num2 = 2;
        Calculator calc1 = new Calculator();
        int sum = calc1.add(num1, num2);
        System.out.println("The sum is: "+ sum);

        int arr[] = { 3,45,9,18,57,66,23};
        int length  = arr.length;

        System.out.println("Unsorted array: "+ Arrays.toString(arr));
        int [] sorted_selection= selection_sort(arr, length);
        System.out.println("Sorted_Selection array: "+  Arrays.toString(sorted_selection));

        int [] sorted_insertion =  insertion_sort(arr);
        System.out.println("Sorted_Insertion array: "+  Arrays.toString(sorted_insertion));
        

        
    }
}
