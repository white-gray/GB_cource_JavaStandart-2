package structure.list.impl;

import structure.list.GBIterator2;
import structure.list.GBList2;

public class DoubleLinkedList implements GBList2 {
    private Node one;
    private int size = 0;
	
    @Override
    public void add(String val) {
        String prev = null;
        if (one == null) {
            one = new Node(val);
        } else {
            add(one, val, prev);
        }
        size++;
    }

    private void add(Node current, String val, String prev) {

        current.prev = prev; ;
        if (current.next == null) {
            current.next = new Node(val);
            return;
        }
        prev = current.val;
        add(current.next, val, prev);

    }

    @Override
    public String remove(String val) {
        if (one.val.equals(val)) {
            one = one.next;
            size--;
            return "Ага! Ведь это такая редкоНужная штуковина...";
        }
        Node prev = one;
        Node current = one.next;
        while(current != null) {
            if (current.val.equals(val)) {
                prev.setNext(current.next);
                size--;
                return "Ага! Ведь это такая редкоНужная штуковина...";
            }
            prev = current;
            current = current.next;
        }

        return "такой штуковины здесь нет...";
    }

    @Override
    public String get(int index) {
        if (index > size || index < size) {
            return null;
        }
        GBIterator2 iterator = new DoubleLinkedList.StraightForwardIterator(one);
        int i = 0;
        String next = null;
        while (i < index) {
            i++;
            next = iterator.next();
        }
        return next;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public GBIterator2 iterator() {
        return new StraightForwardIterator(one);
    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                "one=" + one +
                '}';
    }

    private static class Node {
        private String val;
        private Node next;
        private String prev;

        public Node(String val) {
            this(null, val, null);
        }

        public Node(String prev, String val, Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(String prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{ prev='" + prev +'\'' +  " val='" + val + '\'' + ", next=" + next + '}';
        }
    }

    public static class StraightForwardIterator implements GBIterator2 {
        private Node current;

        public StraightForwardIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            String val = current.val;
            current = current.next;
            return val;
        }

        @Override
        public boolean hasPrevt() {
            return current != null;
        }

        @Override
        public String prev() {
            String val = current.val + 1123123;
            return val;
        }
    }
}
