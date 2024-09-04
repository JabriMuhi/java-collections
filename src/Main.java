import collections.MyArrayList;
import collections.MyLinkedList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> customArray1 = new MyArrayList<>();
        customArray1.add(2);
        customArray1.add(3);
        customArray1.add(4);
        System.out.println(customArray1.get(0));

        if (!customArray1.remove(0)){
            System.out.println("Bad remove");
        }

        customArray1.clear();

        MyArrayList<Integer> customArray2 = new MyArrayList<>();
        customArray2.add(1);
        customArray2.add(7);
        customArray2.add(3);



        System.out.println(customArray2.get(0));
        System.out.println(customArray2.get(1));
        System.out.println(customArray2.get(2));


        ArrayList<Integer> newArrayList1 = new ArrayList<>();

        newArrayList1.add(1);
        newArrayList1.add(7);
        newArrayList1.add(3);

        MyArrayList<Integer> customArray3 = new MyArrayList<>(newArrayList1);
        System.out.println(customArray3.get(0));

        MyArrayList.sortCollection(newArrayList1);
        System.out.println("//////////");
        System.out.println(newArrayList1.get(1));
        System.out.println(customArray3.get(1));

        customArray3.bubbleSort();
        System.out.println(customArray3.get(1));

        MyArrayList<Integer> customArray4 = new MyArrayList<>();
        customArray4.addAll(newArrayList1);

        System.out.println("///////////");
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(2);

        System.out.println(linkedList.get(0)); // 3
        System.out.println(linkedList.get(1)); // 1
        System.out.println(linkedList.get(2)); // 2

        linkedList.bubbleSort();

        System.out.println(linkedList.get(0)); // 1
        System.out.println(linkedList.get(1)); // 2
        System.out.println(linkedList.get(2)); // 3
    }
}