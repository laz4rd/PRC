// Create two interfaces Printable and Shareable. Implement
// both in a class Document and demonstrate multiple inheritance.

interface Printable
{
    void print();
}
interface Shareable
{
    void share();
}
class Document implements Printable, Shareable
{
    String title;

    public Document(String title)
    {
        this.title=title;
    }

    @Override
    public void print()
    {
        System.out.println("printing "+title);
    }
    @Override
    public void share()
    {
        System.out.println("sharing "+title);
    }
}
public class Question16
{
    public static void main(String[] args)
    {
        Document doc = new Document("Hi guis");

        doc.print();
        doc.share();
    }
}