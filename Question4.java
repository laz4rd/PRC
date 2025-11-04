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
        int MAX=a[0];
        int MIN=a[0];

        for(int i=1;i<a.length;i++) //Array large small checker
        {
            if(a[i]>MAX)
            {
                MAX=a[i];
            }
            // if(a[i]<MIN)
            {
                MIN=a[i];
            }
            
        }
        System.out.println(MAX+" is the largest number in the Array");
        System.out.println(MIN+" is the smallest number in the Array");
    }
}