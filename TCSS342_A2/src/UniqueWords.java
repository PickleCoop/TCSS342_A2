/**
 * @author Evan Cooper
 * @version 4/10/2023
 */

import java.io.IOException;

public class UniqueWords {
    public BookReader book;
    public MyArrayList<String> alOfUniqueWords;
    public MyLinkedList<String> llOfUniqueWords;
    public MyOrderedList<String> olOfUniqueWords;

    public UniqueWords(){
        try {
            book = new BookReader("WarAndPeace.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        alOfUniqueWords = new MyArrayList<>();
        llOfUniqueWords = new MyLinkedList<>();
        olOfUniqueWords = new MyOrderedList<>();
    }

    public void addUniqueWordsToLinkedList() {
        System.out.println("\nAdding Unique Words to Linked List...");
        long startTime = System.currentTimeMillis();
        book.words.first();
        for (int i = 0; i < book.words.size(); i++){
            if (!llOfUniqueWords.contains(book.words.current())){
                llOfUniqueWords.addBefore(book.words.current());
            }

            book.words.next();

        }
        long stopTime = System.currentTimeMillis();
        System.out.println(llOfUniqueWords.size() + " Unique Words Found.");
        System.out.println(llOfUniqueWords.comparisons + " Comparisons Made.");
        System.out.println("Initiating Sorting...");
        startTime = System.currentTimeMillis();
        llOfUniqueWords.sort();
        stopTime = System.currentTimeMillis();
        System.out.println("Linked List Sorted in " + ((double)(stopTime - startTime) / 1000) + " Seconds.");
    }

    public void addUniqueWordsToArrayList() {
        System.out.println("\nAdding Unique Words to Array List...");
        long startTime = System.currentTimeMillis();
        book.words.first();
        for (int i = 0; i < book.words.size(); i++){
            if (!alOfUniqueWords.contains(book.words.current())){
                alOfUniqueWords.insert(book.words.current(), alOfUniqueWords.size());
            }
            book.words.next();
        }
        long stopTime = System.currentTimeMillis();
        System.out.println(alOfUniqueWords.size() + " Unique Words Found.");
        System.out.println(alOfUniqueWords.comparisons + " Comparisons Made.");
        System.out.println("Initiating Sorting...");
        startTime = System.currentTimeMillis();
        alOfUniqueWords.sort();
        stopTime = System.currentTimeMillis();
        System.out.println("Array List Sorted in " + ((double)(stopTime - startTime) / 1000) + " Seconds.");
    }

    public void addUniqueWordsToOrderedList(){
        System.out.println("\nAdding Unique Words to Ordered List...");
        long startTime = System.currentTimeMillis();
        book.words.first();
        for (int i = 0; i < book.words.size(); i++){
            if (!olOfUniqueWords.binarySearch(book.words.current())){
                olOfUniqueWords.add(book.words.current());
            }

            book.words.next();
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("Unique Words Added and Sorted into Ordered List in " + (double)(stopTime - startTime)/1000 + " Seconds.");
        System.out.println(olOfUniqueWords.size() + " Unique Words Found.");
        System.out.println(olOfUniqueWords.comparisons + " Comparisons Made.");
    }


}
