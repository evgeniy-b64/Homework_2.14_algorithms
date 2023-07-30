import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new StringListImpl(6);
        System.out.println("Добавлен элемент: "+stringList.add("111"));
        System.out.println("Добавлен элемент: "+stringList.add("222"));
        System.out.println("Добавлен элемент: "+stringList.add("333"));
        System.out.println("Добавлен элемент: "+stringList.add("444"));
        System.out.println("Добавлен элемент: "+stringList.add("555"));
        System.out.println("Весь массив stringList: "+stringList.toString());

        StringList otherList = new StringListImpl();
        System.out.println("Добавлен элемент: "+otherList.add("1x1"));
        System.out.println("Добавлен элемент: "+otherList.add("2x2"));
        System.out.println("Добавлен элемент: "+otherList.add("3x3"));
        System.out.println("Добавлен элемент: "+otherList.add("4x4"));
        //System.out.println("Добавлен элемент: "+otherList.add("5x5"));

        System.out.println("Весь массив otherList: "+otherList.toString());
        System.out.println("Весь массив stringList: "+stringList.toString());
        System.out.println("Массивы равны: "+stringList.equals(otherList));

    }
}