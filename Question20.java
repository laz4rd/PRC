// Create a base class Account with a method calculateInterest(). Derive
// SavingsAccount and FixedDepositAccount, override the method, and demonstrate runtime
// polymorphism.

class Account
{
    double calculateInterest()
    {
        System.out.println("Cant Calculate");
        return 0;
    }
}
class SavingsAccount extends Account
{
    @Override
    public double calculateInterest()
    {
        System.out.println("Calculating Interest for Savings Accounts");
        return 0;
    }
}
class FixedDepositAccount extends Account
{
    @Override
    public double calculateInterest()
    {
        System.out.println("Calculating Interest for Fixed Deposit Accounts");
        return 0;
    }
}
public class Question20
{
    public static void main(String[] args) {
        Account acc;

        acc=new SavingsAccount();
        acc.calculateInterest();
        
        acc=new FixedDepositAccount();        
        acc.calculateInterest();
    }
}