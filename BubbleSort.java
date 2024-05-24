class BubbleSort {

    static void bubbleSort(int array[], int size)
    {
        int i, j, temp;
        for (i = 0; i < size-1; i++) {
            for (j = 0; j < size-i-1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    static void printArray(int array[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int array[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = array.length;
        bubbleSort(array, n);
        System.out.println("Sorted array: ");
        printArray(array, n);
    }
}