public class BinarySearch {
	int binarySearch(int array[], int left, int right, int searchElement)
	{
		while (left <= right) {
			int middle = (left + right) / 2;

			if (array[middle] == searchElement) {
				return middle;
			} else if (array[middle] > searchElement) {
				right = middle - 1;
			} else {
			    left = middle + 1;
			} 
		}
		return -1;
	}

	public static void main(String args[])
	{
		BinarySearch bs = new BinarySearch();

		int array[] = { 2, 3, 4, 10, 40 };
		int length = array.length;
		int searchElement = 10;
		int result = bs.binarySearch(array, 0, length - 1, searchElement);

		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index "+ result);
	}
}
