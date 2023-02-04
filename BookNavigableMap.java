/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author albaraa
 */
public class BookNavigableMap {

    /**
     * @return @throws java.io.FileNotFoundException
     */
    static NavigableMap<String,Book> books = new TreeMap();

    public static int size() {
        return books.size();
    }

    public void print() {
        
        for (Book value : books.values()) {
            System.out.println(value.getTitle());
            System.out.println(value.getQuantity());
        }
    }
    
    public Set<String> search(){
        return books.keySet();
    }

    public BookNavigableMap() {
        // TODO code application logic here
        try {
            File file = new File("C:\\Users\\albaraa\\Desktop\\books_file.txt");
            Scanner sc = new Scanner(file);

            int book_num = Integer.parseInt(sc.nextLine());
            int count = 1;
            while (sc.hasNextLine()) {
                Book b1 = new Book();

                b1.setBook_id(Integer.parseInt(sc.nextLine()));
                b1.setTitle(sc.nextLine());
                b1.setAuthor(sc.nextLine());
                b1.setQuantity(Integer.parseInt(sc.nextLine()));
                b1.setIsbn(Long.parseLong(sc.nextLine()));
                b1.setPublisher(sc.nextLine());
                b1.setTotal_pages(Integer.parseInt(sc.nextLine()));
                b1.setRating(Float.parseFloat(sc.nextLine()));
                b1.setPublished_date(sc.nextLine());

                if (count < book_num) {
                    sc.nextLine();
                }
                books.put(b1.getTitle(), b1);
                count++;
            }

        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println("error");
        }
    }

    public void updateBook(Book book) {
        books.replace(book.getTitle(), book);
    }

    public String insertBook(Book book) {
        String s = null;
        if (exist(book.getTitle())) {
            s = "This book already exists";
        } else {
            books.put(book.getTitle(), book);
        }
        return s;
    }

    public Book delete(String title, int quantity) {
        if (books.get(title) == null) {
            return null;
        }
        int count = books.get(title).getQuantity();
        if (count > quantity) {
            books.get(title).setQuantity(count - quantity);
            return books.get(title);
        } else {
            return books.remove(title);
        }
    }

    public Book get(String title) {
        return books.get(title);
    }

    public boolean exist(String title) {
        return books.containsKey(title);
    }
}
