interface Payment
{
    void pay();
}

class CreditCardPayment implements Payment
{
    @Override
    public void pay()
    {
        System.out.println("Paying using Credit Card");
    }
}

class UPIPayment implements Payment
{
    @Override
    public void pay()
    {
        System.out.println("Paying using UPI");
    }
}

public class Q18
{
    public static void main(String[] args) {
        Payment cred = new CreditCardPayment();
        Payment upi = new UPIPayment();

        cred.pay();
        upi.pay();
    }
}