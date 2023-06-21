
/**
 * @author Evan Cooper
 * @version 4/10/2023
 */

public class MyOrderedList<Type extends  Comparable<Type>> {
    protected MyArrayList<Type> list;
    public long comparisons;

    public MyOrderedList() {
        this.list = new MyArrayList<>();
    }

    public void add(Type item){
        Type temp;
        comparisons++;

        list.insert(item, list.size());
        for (int i = list.size() - 1; i > 0; i--){
            if (item.compareTo(list.get(i - 1)) < 0){
                comparisons++;
                temp = list.get(i - 1);
                list.set(i - 1, item);
                list.set(i, temp);
            }
        }


    }

    public Type remove(Type item){
        for (int i = 0; i < list.size(); i++){
            if (list.contains(item)){
                return remove(item);
            }
        }
        return null;
    }

    public boolean binarySearch(Type item){
        int low = 0;
        int high = list.size - 1;

        while (low <= high){

            int middle = (high + low) / 2;
            comparisons++;
            if (item.compareTo(list.get(middle)) == 0){
                return true;
            } else if (item.compareTo(list.get(middle)) > 0){
                low = middle + 1;
            } else {
                high = middle - 1;
            }

        }
        return false;
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public String toString(){
        return list.toString();
    }



}
