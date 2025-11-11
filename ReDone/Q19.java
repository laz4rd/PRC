
import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }   
}

public class Q19
{
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter your age");
            int age=sc.nextInt();

            sc.close();

            if(age<18)
            {
                throw new InvalidAgeException("Age must be 18 or above");
            }
            else
            {
                System.out.println("Valid voter");
            }
        } catch (InvalidAgeException e){
            System.out.println("Exception: "+e.getMessage());
        }
    }
}