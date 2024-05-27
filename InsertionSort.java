public class InsertionSort {
    void sort(int array[])
    {
        int size = array.length;
        for (int i = 1; i < size; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    static void printArray(int array[])
    {
        int size = array.length;
        for (int i = 0; i < size; ++i)
            System.out.print(array[i] + " ");

        System.out.println();
    }

    public static void main(String args[])
    {
        int array[] = { 12, 11, 13, 5, 6 };

        InsertionSort ob = new InsertionSort();
        ob.sort(array);

        printArray(array);
    }
};