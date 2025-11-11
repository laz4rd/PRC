import java.util.Scanner;

class InvalidAgeException extends Exception
{
    public InvalidAgeException(String message)
    {
        super(message);
    }
}

public class Q19
{
    public static void main(String[] args) {
        try {
            Scanner sc=new Scanner(System.in);

            System.out.println("Enter your age");
            int age=sc.nextInt();

            if(age<18)
            {
                throw new InvalidAgeException("Invalid Age for Voting");
            }
            else
            {
                System.out.println("Valid Age to vote");
            }
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: "+ e.getMessage());
        }
    }
}