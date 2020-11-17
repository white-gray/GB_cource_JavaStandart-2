package structure.list;

import structure.list.impl.DoubleLinkedList;
import structure.list.impl.SingleLinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GBList list = new SingleLinkedList();
        list.add("BMW");
        list.add("TOYOTA");
        list.add("GAZ");
        list.add("TOYOTA");

        System.out.println("We have the SingleLinkedList :");
        GBIterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("\t\t"+next);
        }
        System.out.println("\nSize before remove " + list.size());

        boolean isToyotaRemoved = list.remove("TOYOTA");
        System.out.println("\ns toyota removed? " + isToyotaRemoved);
        System.out.println("Size after remove " + list.size());

        System.out.println("\tSingleLinkedList position -1 : " + list.get(-1));
        System.out.println("\tSingleLinkedList position 0 : " + list.get(0));
        System.out.println("\tSingleLinkedList position 1 : " + list.get(1));
        System.out.println("\tSingleLinkedList position 2 : " + list.get(2));
        System.out.println("\tSingleLinkedList position 3 : " + list.get(3));
        System.out.println("\tSingleLinkedList position 30 : " + list.get(30));
        System.out.print("\n-------------------------\n and now SingleLinkedList: " + list);


        System.out.println("\n--------------------------------------------------------------------\n");
        GBList2 listDouble = new DoubleLinkedList();
        listDouble.add("правая нога");
        listDouble.add("левая нога");
        listDouble.add("вело");
        listDouble.add("автобус");
        listDouble.add("электричка");
        listDouble.add("такси");

        System.out.println("We have the DoubleLinkedList :");
        GBIterator2 iterator2 = listDouble.iterator();
        while (iterator2.hasNext()) {
            String next = iterator2.next();
            System.out.println(	"\t\t"+next);
        }
        System.out.println("\nSize before remove " + listDouble.size());

        String isCarRemoved = listDouble.remove("машинка");
        System.out.println("\nIs car removed? " + isCarRemoved);
        String isTaxiRemoved = listDouble.remove("такси");
        System.out.println("\nIs taxi removed? " + isTaxiRemoved);
        System.out.println("\nSize after remove " + listDouble.size());
        System.out.print("\n\n-------------------------\n and now DoubleLinkedList: \n" + listDouble);
    }
}
