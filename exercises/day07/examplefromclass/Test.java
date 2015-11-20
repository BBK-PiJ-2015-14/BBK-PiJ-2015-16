package examplefromclass;

public class Test {
    public static void main(String[] args) {
        LinkedList lList = new LinkedListImpl();

        // add elements to LinkedList
        lList.add(1);
        lList.add(2);
        lList.add(3);
        lList.add(4);
        lList.add(5);

        System.out.println("lList - print linkedlist: " + lList);
        System.out.println("lList.size() - print linkedlist size: "
                + lList.size());
        System.out.println("lList.get(3) - get 3rd element: " + lList.get(3));
        System.out.println("lList.remove(2) - remove 2nd element: "
                + lList.remove(2));
        System.out.println("lList.get(3) - get 3rd element: " + lList.get(3));
        System.out.println("lList.size() - print linkedlist size: "
                + lList.size());
        System.out.println("lList - print linkedlist: " + lList);
    }
}