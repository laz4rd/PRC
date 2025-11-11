class Box<T> {
    T value;

    public Box(T value) {
        this.value = value;
    }

    public T display() {
        return value;
    }
}

public class Q10 {
    public static void main(String[] args) {
        Box<Integer> boxInt = new Box<>(10);
        System.out.println("Integer value: " + boxInt.value);

        Box<String> boxString = new Box<>("laz4rd");
        System.out.println("String Value: " + boxString.value);

        Box<Character> boxChar = new Box<>('c');
        System.out.println("Character Value " + boxChar.value);
    }
}