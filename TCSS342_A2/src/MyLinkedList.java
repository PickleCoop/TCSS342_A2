/**
 * @author Evan Cooper
 * @version 4/10/2023
 */

public class MyLinkedList<Type extends Comparable<Type>> {
    protected Node first;
    protected Node current;
    protected Node previous;
    protected int size;
    public long comparisons;


    // Constructor
    public MyLinkedList() {
        first = null;
        current = null;
        previous = null;
    }

    // Node class that stores the reference to the next node and the item
    protected class Node {
        public Type item;
        public Node next;

        public String toString(){
            return item.toString();
        }
    }

    // Method adds a node between the previous and current nodes
    public void addBefore(Type item){
        Node newNode = new Node();
        newNode.item = item;

        if (current == null){

            if (previous == null) {
                previous = newNode;
                first = previous;
            } else {
                newNode.next = null;
                previous.next = newNode;
                previous = newNode;
            }

        }

        if (current == first){
            first = newNode;
        }

        previous.next = newNode;
        newNode.next = current;
        previous = newNode;
        size++;
    }

    // Method adds a node after the current node
    public void addAfter(Type item){
        Node newNode = new Node();
        newNode.item = item;

        if (current != null){
            if (current.next != null){
                newNode.next = current.next;
            }
            current.next = newNode;
            size++;
        }
    }

    // Method removes a specified node and reconnects the chain
    public Type remove(){
        if (current == null){
            return null;
        }

        Type store = current.item;

        if (current == first){
            first = first.next;
            current = first;
            previous = first;
        } else {
            previous.next = current.next;
            current = current.next;
        }

        size--;
        return store;
    }

    // Returns the item of the current node
    public Type current(){

        if (current == null) {
            return null;
        } else {
            return current.item;
        }
        
    }

    // Returns the item of the first node
    public Type first(){
        if (first == null) return null;
        current = first;
        return first.item;
    }

    // Returns the item of the next node of the given node
    public Type next(){

        if (current == null){
            return null;
        } else {
            previous = current;
            current = current.next;
            if (current == null){
                return null;
            }
            return current.item;
        }

    }

    // Returns true the list contains a specified item, false if not
    public boolean contains(Type item){
        Node temp = new Node();
        temp = first;

        if (size > 0){

            while (temp != null){
                comparisons++;
                if (temp.item.compareTo(item) == 0){
                    return true;
                }
                temp = temp.next;
            }

        }

        return false;
    }

    // Returns the size of the list
    public int size(){
        return size;
    }

    // Returns true if the list is empty, false if not
    public boolean isEmpty(){
        return size == 0;
    }

    // Returns the String version of the linked list
    public String toString(){
        StringBuilder output = new StringBuilder();
        String prefix = "";
        output.append("[");

        for (Node iterator = first; iterator != null; iterator = iterator.next) {
            output.append(prefix).append(iterator.toString());
            prefix = ", ";
        }

        output.append("]");
        return output.toString();
    }

    public void sort(){
        if (size == 0){
            return;
        }
        Type temp = null;
        boolean sort = false;
        while (!sort){
            sort = true;
            for (Node iterator = first; iterator.next != null; iterator = iterator.next){
                if (iterator != null && iterator.next != null && iterator.item.compareTo(iterator.next.item) > 0){
                    temp = iterator.item;
                    iterator.item = iterator.next.item;
                    iterator.next.item = temp;
                    sort = false;
                }
            }
        }

    }

}
