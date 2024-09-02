
class Heap
{
    public void min_heap(int A[], int n, int i)
    {
        int smallest = i;
        int left = 2*i +1;
        int right = 2*i + 2;
        if (left < n && A[left]< A[smallest])
        {
            smallest = left;
        }
        if(right < n && A[right] < A[smallest])
        {
            smallest = right;
        }
        if ( smallest != i)
        {
            int temp = A[i];
            A[i] = A[smallest];
            A[smallest] = temp;
            min_heap(A, n, smallest);
        }
    }
    
    public void max_heap( int A[], int n, int i)
    {
        int largest = i;
        int left = 2*i +1;
        int right = 2*i +2;

        if(left < n && A[left] > A[largest])
        {
            largest = left;
        }
        if(right < n && A[right] > A[largest])
        {
            largest = right;
        }
        if(largest != i)
        {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            max_heap(A, n, largest);
        }
    }
    public int[] heap_sort(int A[], int n)
    {
        for (int i = n/2 -1; i >= 0; i--)
        {
            //max_heap(A, n, i);
            min_heap(A, n, i);
        }

        for( int i = n-1; i >= 0; i--)
        {
            int temp = A[i];
            A[i] = A[0];
            A[0] = temp;
            //max_heap(A, i, 0);
            min_heap(A, i, 0);
        }
        
        return A;
    }

            
}


public class Heap_Sort 
{    
    public static void main(String args[])
    {
        int A[] = {10,20,15,30,40,45};
        int n = A.length;
        Heap h = new Heap(); 
        h.heap_sort(A, n);
        for(int i = 0; i < n; i++)
        {
            System.out.print(A[i] + " ");
        }
        System.out.println();

    }
    
}
