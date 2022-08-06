package LinkedListAndPoint;

public class LinkedListAndPoint extends Node {
    private Node first;
    private Node last;
    private int size;

    public boolean add(Object obj) {
        Node n = new Node();
        if (first == null) {
            n.setPrev(null);
            n.setObj(obj);
            n.setNext(null);

            first = n;
        } else {
            n.setPrev(last);
            n.setObj(obj);
            n.setNext(null);

            last.setNext(n);
        }
        last = n;
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        Node temp = node(index);

        if (temp != null) {
            Node up = temp.getPrev();
            Node down = temp.getNext();
            up.setNext(down);
            if (down != null) {
                down.setPrev(up);
            }
        }
        size--;
    }

    public Node node(int index) {
        Node temp = null;
        if (first != null) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        }
        return temp;
    }

    public Object get(int index) {
        Node temp = node(index);
        if (temp != null) {
            return temp.getObj();
        } else {
            return null;
        }
    }

    public void add(int index, Object obj) {
        Node temp = node(index);

        Node newNode = new Node();
        newNode.setObj(obj);

        if (temp != null) {
            Node up = temp.getPrev();
            up.setNext(newNode);
            newNode.setPrev(up);

            newNode.setNext(temp);
            temp.setPrev(newNode);
        }
        size++;
    }

    public void set(int index, Object obj) {
        Node temp = node(index);
        if (temp != null) {
            temp.setObj(obj);
        }
    }
    public void show() {
        Node temp = new Node();
        if (first != null) {
            temp = first;
            while (temp != null) {
                System.out.print(temp.getObj() + " ");
                temp = temp.getNext();
            }
        }
    }

    public static void main(String[] args) {
        LinkedListAndPoint list = new LinkedListAndPoint();

        list.add("Moscow");
        list.add("Kazan");
        list.add("Yekaterinburg");
        list.add("Saint-P");
        list.add("Perm");
        list.add("Sochi");
        list.add("Volgograd");

        list.remove(4);
        list.set(5, "1");
        list.add(3, "Voronezh");
        System.out.println(list.get(6));
        System.out.println(list.get(3));
        System.out.println(list.get(2));
        System.out.println(list.size());

    }
}
