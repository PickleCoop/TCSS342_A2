/**
 * @author Evan Cooper
 * @version 4/10/2023
 */

import java.io.*;
import java.util.Scanner;


public class BookReader {
    public String book;
    public MyLinkedList<String> words;

    public BookReader(String filename) throws IOException {
        this.book = "";
        this.words = new MyLinkedList<>();
        readBook(filename);
        parseWords();
    }

    public void readBook(String filename) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("Searching for Characters...");
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        StringBuilder builder = new StringBuilder(book);
        int character = reader.read();
        while(character != -1){
            builder.append((char) character);
            character = reader.read();
        }
        int count = builder.length();
        book = builder.toString();
        long stopTime = System.currentTimeMillis();
        System.out.println(count + " Characters Read.");
        System.out.println("Time to Read and Write: " + (stopTime - startTime)  + " Milliseconds.");
    }

    public void parseWords(){
        long startTime = System.currentTimeMillis();
        System.out.println("\nSearching for Words...");
        StringBuilder wordBuffer = new StringBuilder();
        int i = 0;
        while (i < book.length()){
            char currChar = book.charAt(i);
            i++;
            if ((currChar == 39) ||
                (currChar > 47 && currChar < 58) ||
                (currChar > 64 && currChar < 91) ||
                (currChar > 96 && currChar < 123)){
                wordBuffer.append(currChar);
            } else {
                if (wordBuffer.length() > 0) {
                    if (words.current == null){
                        words.addBefore(wordBuffer.toString());
                        words.current = words.first;
                    } else {
                        words.addAfter(wordBuffer.toString());
                        words.current = words.current.next;
                    }
                    wordBuffer.setLength(0);
                }
            }

        }
        long stopTime = System.currentTimeMillis();
        System.out.println(words.size() + " Words Read.");
        System.out.println("Time to Find Words: " + (stopTime - startTime) + " Milliseconds.");



    }

}
