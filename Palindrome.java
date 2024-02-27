import java.util.*;

class Palindrome{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String str = s.nextLine();
		if(isPalindrome(str))
			System.out.println("The string "+ str +" is a palindrome."); 
		else
			System.out.println("The string " + str + " is not a palindrome.");
	}
	
	public static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
        	while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false; 
			}
			left++;
			right--;
        	}
		return true;
	}
}
