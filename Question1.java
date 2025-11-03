// Write a Java program to calculate and display the gross salary of an employee,
// where HRA = 20%, DA = 50%, and PF = 11% of the basic salary.

import java.util.Scanner;

public class Question1
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Input your base salary");
        double BASE = sc.nextDouble();

        System.out.println(BASE+" is your salary");

        double hra = BASE*0.20;
        double da  = BASE*0.50;
        double pf  = BASE*0.11;

        double GS  = BASE+hra+da-pf;

        System.out.println("The GROSS SALARY is "+GS);

    }
}