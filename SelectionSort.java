public class SelectionSort
{
    void sort(int array[])
    {
        int size = array.length;

        for (int i = 0; i < size-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < size; j++)
                if (array[j] < array[min_idx])
                    min_idx = j;
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
    }

    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[])
    {
        SelectionSort ss = new SelectionSort();
        int array[] = {64,25,12,22,11};
        ss.sort(array);
        System.out.println("Sorted array");
        ss.printArray(array);
    }
}