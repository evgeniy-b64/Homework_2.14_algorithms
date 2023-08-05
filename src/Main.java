import Model.IntegerList;
import Model.IntegerListImpl;

public class Main {
    public static void main(String[] args) {
        IntegerList integerList = new IntegerListImpl(16);
        System.out.println("Добавлен элемент: "+integerList.add(111));
        /*System.out.println("Добавлен элемент: "+integerList.add(222));
        System.out.println("Добавлен элемент: "+integerList.add(333));
        System.out.println("Добавлен элемент: "+integerList.add(444));
        System.out.println("Добавлен элемент: "+integerList.add(555));*/
        System.out.println("Весь массив integerList: "+integerList);

        IntegerList otherList = new IntegerListImpl();
        System.out.println("Добавлен элемент: "+otherList.add(11));
        /*System.out.println("Добавлен элемент: "+otherList.add(22));
        System.out.println("Добавлен элемент: "+otherList.add(33));
        System.out.println("Добавлен элемент: "+otherList.add(44));*/
        //System.out.println("Добавлен элемент: "+otherList.add(55));

        System.out.println("Весь массив otherList: "+ otherList);
        System.out.println("Весь массив integerList: "+ integerList);
        System.out.println("Массивы равны: "+integerList.equals(otherList));
    }
}