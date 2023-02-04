/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.*;

/**
 *
 * @author albaraa
 */
public class HashMap0 {

    HashMap<Integer, ArrayList<Book>> ub = new HashMap<>();
    BookNavigableMap Book = new BookNavigableMap();
    UsersNavigableMap users = new UsersNavigableMap();

    public int exist(int id, String title) {
        int index = -1;
        for (int i = 0; i < ub.size(); i++) {
            for (int j = 0; j < ub.get(i).size(); j++) {
                if(i == id && ub.get(i).get(j).getTitle().equals(title)){
                  index = j;
                }
            }
        }
        return index;
    }

    public void buy(int id, String title, int quantity) {
        int count = exist(id, title);
        if (ub.get(id) != null) {
            if (count != -1) {
                int oldQuatity = ub.get(id).get(count).getQuantity();
                ub.get(id).get(count).setQuantity(oldQuatity + quantity);
            } else {
                ub.get(id).add(helper(title, quantity));
            }
        } else {
            ArrayList<Book> b = new ArrayList<>();
            Book book = helper(title, quantity);
            b.add(book);
            ub.put(id, b);
        }
        Book.delete(title, quantity);
    }
    
    private Book helper(String title, int quantity){
        Book b = new Book();
        Book s = Book.get(title);
        b.setTitle(title);
        b.setBook_id(s.getBook_id());
        b.setIsbn(s.getIsbn());
        b.setAuthor(s.getAuthor());
        b.setPublished_date(s.getPublished_date());
        b.setPublisher(s.getPublisher());
        b.setQuantity(quantity);
        b.setTotal_pages(s.getTotal_pages());
        b.setRating(s.getRating());
        return b;
    }
    
    public User userData(int id){
        return users.serach(id);
    }
    
    public void delete(int id, String title){
        ub.get(id).remove(exist(id, title));
    }

    public void print() {
        for(int i = 0;i < ub.size();i++){
            System.out.println("-------------");
            for (int j = 0; j < ub.get(i).size(); j++) {
                System.out.println(ub.get(i).get(j).getTitle());
                System.out.println(ub.get(i).get(j).getQuantity());
            }
        }
    }

//    public int size(){
//        return a.size();
//    }
//
//    public int exist(int id, String title) {
//        int e = -1;
//        for (int i = 0; i < a.size(); i++) {
//            for (int j = 0; j < a.get(i).size(); j++) {
//                if (i == id && a.get(id).get(j).getTitle().equals(title)) {
//                    e = j;
//                }
//            }
//        }
//        return e;
//    }
//
//    public void buy(int id, String title, int quantity){
//        ArrayList<Book> b = new ArrayList<>();
//        if (exist(id, title) != -1) {
//            helper(id, title, quantity);
//        }else{
//            int oldQuantity = Book.get(title).getQuantity();
//            Book.get(title).setQuantity(quantity);
//            b.add(Book.get(title));
//            a.add(b);
//            ub.put(id, a);
//            Book.get(title).setQuantity(oldQuantity);
//        }
//            
//    }
//    
//    private void helper(int id, String title, int quantity){
//        int n = exist(id, title);
//        ArrayList f = (ArrayList)ub.get(id);
//        a.get(id).get(n).setQuantity(a.get(id).get(n).getQuantity() + quantity);
//    }
//    
//    public ArrayList search(int id) {
//        return a.get(id);
//    }
//    
//    public User userData(int id){
//        return users.serach(id);
//    }
//
//    private void delete(int id, String title) {
//        a.get(id).remove(exist(id, title));
//    }
//
//    public int delete(int id, String title, int num) {
//        int count = a.get(id).get(exist(id, title)).getQuantity();
//        if (count == num) {
//            delete(id, title);
//        } else {
//            a.get(id).get(exist(id, title)).setQuantity(count - num);
//        }
//        return count - num;
//    }
//
//    public void print() {
//        for (int i = 0; i < a.size(); i++) {
//            for (int j = 0; j < a.get(i).size(); j++) {
//                System.out.println(a.get(i).get(j).getTitle());
//                System.out.println(a.get(i).get(j).getAuthor());
//                System.out.println(a.get(i).get(j).getBook_id());
//                System.out.println(a.get(i).get(j).getQuantity());
//                System.out.println(a.get(i).get(j).getIsbn());
//                System.out.println(a.get(i).get(j).getPublished_date());
//                System.out.println(a.get(i).get(j).getPublisher());
//                System.out.println(a.get(i).get(j).getRating());
//                System.out.println(a.get(i).get(j).getTotal_pages());
//
//            }
//        }
//    }
}
