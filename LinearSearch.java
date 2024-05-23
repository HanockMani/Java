public class LinearSearch { 

	static int linearSearch(int array[], int size, int searchElement) 
	{ 
		for (int i = 0; i < size; i++) { 
			if (array[i] == searchElement) 
				return i; 
		} 
		return -1; 
	} 

	public static void main(String[] args) 
	{ 
		int[] arr = { 3, 4, 1, 7, 5 }; 
		int size = arr.length; 
		
		int searchElement = 4; 

		int index = linearSearch(arr, size, searchElement); 
		if (index == -1) 
			System.out.println("Element is not present in the array"); 
		else
			System.out.println("Element found at position " + index); 
	} 
}