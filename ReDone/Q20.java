class Acc 
{
    private int AccNo;
    private double Pr;

    public Acc(int AccNo, double Pr) {
        this.AccNo = AccNo;
        this.Pr = Pr;
    }
    void Interest()
    {
        System.out.println("Invalid Account Type");
    }
}

class SavingsAccount extends Acc
{
    public SavingsAccount(int AccNo, double Pr)
    {
        super(AccNo, Pr);
    }

    @Override
    void Interest()
    {
        System.out.println("Interest calculated! for Savings Account");
    }
}

class fda extends Acc
{
    public fda(int AccNo, double Pr)
    {
        super(AccNo, Pr);
    }

    @Override
    void Interest()
    {
        System.out.println("Interest calculated for FDA");
    }
}

public class Q20
{
    public static void main(String[] args) {
        Acc sa = new SavingsAccount(123, 917381);
        Acc fd = new fda(321, 3801);

        sa.Interest();
        fd.Interest();
    }
}