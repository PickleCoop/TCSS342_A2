/**
 * @author Evan Cooper
 * @version 4/10/2023
 */

public class MyArrayList<Type extends Comparable<Type>> {
    protected Type[] list;
    protected int capacity;
    protected int size;
    public long comparisons = 0;

    //Constructor
    public MyArrayList() {
        this.capacity = 16;
        this.list = (Type[]) new Comparable[capacity];
    }

    //Method inserts item into specified index
    public void insert(Type item, int index){
        if(index > size || index < 0){
            return;
        }

        if (capacity == size){
            resize();
        }

        for(int i = capacity - 1; i >= index; i--){
            if (list[i] != null) {
                list[i + 1] = list[i];
            }
        }
        list[index] = item;
        size++;
    }

    // Method removes item at specified index and returns
    public Type remove(int index){

        if (index < 0 || index > size){
            return null;
        }

        Type returnValue = list[index];

        for(int i = index; i < capacity - 1; i++){
            list[i] = list[i + 1];
        }

        size--;
        return returnValue;
    }

    // Method returns true if contains specified item, false if not
    public boolean contains(Type item){

        for (int i = 0; i < size; i++){
            comparisons++;
           if (list[i].compareTo(item) == 0){
               return true;
           }

       }

       return false;
    }

    // Method returns the index of a specified item
    public int indexOf(Type item){

        for (int i = 0; i <= size; i++){

            if (list[i].compareTo(item) == 0){
                return i;
            }

        }

        return -1;
    }

    // Method returns item at specified index
    public Type get(int index){

        if (index >= 0 && index < capacity){
            return list[index];
        }

        return null;
    }

    // Method sets a specified index to a specified item
    public void set(int index, Type item){

        if (index >= 0 && index < capacity){
            list[index] = item;
        }

    }

    // Returns the size of the array list
    public int size(){
        return size;
    }

    // Returns true if the list is empty, false if not
    public boolean isEmpty(){
        return size == 0;
    }

    // Returns the String converted array list
    public String toString(){
        String arrayString;
        arrayString = "[";

        for (int i = 0; i < size - 1; i++){
            arrayString = arrayString.concat(list[i] + ", ");
        }
        if (size == 0){
            return "[]";
        }
        return arrayString = arrayString.concat(list[size - 1] + "]");
    }

    // Method is called if the array list is too small
    protected void resize(){
        capacity *= 2;
        Type[] mirror = (Type[]) new Comparable[capacity];
        System.arraycopy(list, 0, mirror, 0, list.length);
        list = mirror;
    }

    public void sort(){
        Type temp = null;
        if (isEmpty()){
            return;
        }
        for (int i = 0; i < size() - 1; i++){
            for (int j = 0; j  < size() - 1 - i; j++){
                if (list[j + 1] != null) {
                    if (list[j].compareTo(list[j + 1]) > 0) {
                        temp = list[j];
                        list[j] = list[j + 1];
                        list[j + 1] = temp;
                    }
                }
            }
        }

    }

}
