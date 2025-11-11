interface Printable {
    void print();
}

interface Shareable {
    void share();
}

class Document implements Shareable, Printable {
    String title;

    public Document(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Printing " + title);
    }

    @Override
    public void share() {
        System.out.println("Sharing " + title);
    }
}

public class Q16 {
    public static void main(String[] args) {
        Document doc = new Document("Nothing");

        doc.print();
        doc.share();
    }
}