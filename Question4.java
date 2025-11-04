// Write a Java program to input 5 integers, store them in an array
// and display the maximum and minimum numbers.

import java.util.*;

public class Question4
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] a = new int[5]; //ini

        for(int i=0;i<a.length;i++) //Array Input
        {
            a[i]=sc.nextInt();
        }
        int MAX=0;
        int MIN=0;
        int temp=0;
        for(int i=1;i<a.length;i++) //Array large small checker
        {
            if(a[i]>a[i-1])
            {
                MAX  = a[i];
                temp = MAX;
            }
            if(a[i]<a[i-1])
            {
                MIN=a[i];
            }
            
        }
        System.out.println(MAX+" is the largest number in the Array");
        System.out.println(MIN+" is the smallest number in the Array");
    }
}