package Original;
// Create a generic class Box<T> to store a single value

// and display it for both Integer and String types.

public class Question10 {
    static class Box<T> {
        private T value;

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void display() {
            System.out.println("value is " + value);
        }
    }

    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.setValue(55);
        intBox.display();

        Box<String> strBox = new Box<>();
        strBox.setValue("ThisIsAString");
        strBox.display();
    }

}