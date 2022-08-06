package ArrayListAndPoint;

import java.util.Iterator;

public class ArrayListAndPoint<E> implements MethodArray<E> {


    private E[] values;

    ArrayListAndPoint() {
        values = (E[]) new Object[0];
    }
    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;

        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;


    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int elementsAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, elementsAfterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }


    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    public static void main(String[] args) {
        MethodArray<String> str = new ArrayListAndPoint<String>();
        str.add("One");
        str.add("Two");
        str.add("Three");
        str.add("Four");
        str.add("Five");
        str.add("Six");

        str.update(3, "Четыре");
        str.delete(5);

        System.out.println(str.size());
        System.out.println(str.get(3));
        for (String newStr : str) {
            System.out.println(newStr);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }



}

