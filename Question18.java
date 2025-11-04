// Create an interface Payment with method pay(). Implement it in two classes
// CreditCardPayment and UPIPayment. Demonstrate both payments.

interface Payment
{
    void pay();
}
class CreditCardPayment implements Payment
{
    @Override
    public void pay()
    {
        System.out.println("Paying via Credit Card");
    }
}
class UPIPayment implements Payment
{
    @Override
    public void pay()
    {
        System.out.println("Paying via UPI");
    }
}
public class Question18
{
    public static void main(String[] args) {
        UPIPayment upi=new UPIPayment();
        CreditCardPayment crd=new CreditCardPayment();

        upi.pay();
        crd.pay();
    }
}