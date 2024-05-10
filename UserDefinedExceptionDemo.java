import java.util.*;

class MyException extends Exception{
    public MyException(String error){
        super(error);
    }
}

public class UserDefinedExceptionDemo{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder word = new StringBuilder(); 
        
        System.out.println("Enter a word with 5 letters...");
        String wordString = scanner.nextLine();
        word.append(wordString);

        try{
            if(word.length() < 5){
                throw new MyException("Not Enough Letters!");
            }
            else if(word.length() >5){
                throw new MyException("Too many Letters!");
            }
            else{
                System.out.println("The reverse of the word is "+word.reverse());
            }
        }
        catch(MyException e){
            System.out.println(e);
        }
    }
}