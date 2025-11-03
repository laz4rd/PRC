/*Write a Java program to check whether an entered number
is even or odd using the if-else statement*/

import java.util.*;
public class Question3
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter A Number");
        int inp = sc.nextInt();

        if (inp%2==0) {
            System.out.println("Even");
        }    
        else
        {
            System.out.println("Odd");
        }
    }
}