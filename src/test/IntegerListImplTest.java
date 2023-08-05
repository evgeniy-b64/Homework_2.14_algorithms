package test;

import static org.junit.jupiter.api.Assertions.*;

import Exceptions.ItemNotFoundException;
import Model.IntegerList;
import Model.IntegerListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerListImplTest {

    IntegerList stringList = new IntegerListImpl();

    @Test
        // элемент добавляется
    void methodAddsItem() {
        stringList.add(111);
        Assertions.assertTrue(stringList.contains(111));
    }

    @Test
        // элемент добавляется по указанному индексу
    void methodAddsItemOnIndex() {
        stringList.add(111);
        stringList.add(111);
        stringList.add(1, 222);
        Assertions.assertEquals(stringList.get(1), 222);
    }

    @Test
        // метод выбрасывает исключение
    void methodAddThrowsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stringList.add(1, 222));
    }

    @Test
    void methodSetThrowsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stringList.set(1, 222));
    }

    @Test
    void methodSetsElementByIndex() {
        stringList.add(111);
        stringList.add(111);
        stringList.set(1, 222);
        Assertions.assertEquals(stringList.get(1), 222);
    }

    @Test
    void methodRemovesItem() {
        stringList.add(111);
        stringList.add(222);
        stringList.remove(222);
        Assertions.assertFalse(stringList.contains(222));
    }

    @Test
    void methodRemoveThrowsException() {
        assertThrows(ItemNotFoundException.class, () -> stringList.remove(111));
    }

    @Test
    void methodRemovesItemByIndex() {
        stringList.add(111);
        stringList.add(222);
        stringList.remove(1);
        Assertions.assertFalse(stringList.contains(222));
    }

    @Test
    void methodContainsTest() {
        stringList.add(111);
        Assertions.assertTrue(stringList.contains(111));
        Assertions.assertFalse(stringList.contains(222));
    }

    @Test
    void methodReturnsIndex() {
        stringList.add(111);
        Assertions.assertEquals(stringList.indexOf(111), 0);
        Assertions.assertEquals(stringList.indexOf(222), -1);
    }

    @Test
    void methodLastIndexTest() {
        stringList.add(111);
        Assertions.assertEquals(stringList.lastIndexOf(111), 0);
        Assertions.assertEquals(stringList.lastIndexOf(222), -1);
    }

    @Test
    void methodGetsElementByIndex() {
        stringList.add(111);
        Assertions.assertEquals(stringList.get(0), 111);
    }

    @Test
    void methodGetThrowsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stringList.get(1));
    }

    @Test
    void testEqualsTrue() {
        stringList.add(111);
        IntegerList otherList = new IntegerListImpl();
        otherList.add(111);
        Assertions.assertTrue(stringList.equals(otherList));
    }

    @Test
    void testEqualsFalse() {
        stringList.add(111);
        IntegerList otherList = new IntegerListImpl();
        otherList.add(77);
        Assertions.assertFalse(stringList.equals(otherList));
    }

    @Test
    void methodSizeTest() {
        Assertions.assertEquals(stringList.size(), 0);
        stringList.add(111);
        Assertions.assertEquals(stringList.size(), 1);
    }

    @Test
    void isEmptyTest() {
        Assertions.assertTrue(stringList.isEmpty());
        stringList.add(111);
        Assertions.assertFalse(stringList.isEmpty());
    }

    @Test
    void clear() {
        stringList.add(111);
        stringList.clear();
        Assertions.assertTrue(stringList.isEmpty());
    }

    @Test
    void toArray() {
    }

    @Test
    void testToString() {
    }
}