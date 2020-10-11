package com.devepkm.test;

import com.devepkm.bean.Book;
import com.devepkm.dao.BookDao;
import com.devepkm.dao.impl.BookDaoImpl;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: dev
 * @Date: 1/10/2020 11:58
 * @Description:
 */
public class BookDaoImplTest {

    BookDao dao = new BookDaoImpl();


    @org.junit.Test
    public void addBook() {
        dao.addBook(new Book("adfs", "adfads", new BigDecimal(334.2), 5, 5, "dgfs.jph"));
    }

    @org.junit.Test
    public void deleteBookById() {
        dao.deleteBookById(2);

    }

    @org.junit.Test
    public void updateBook() {
        dao.updateBook(new Book(1,"java", "me", new BigDecimal(12.35), 34, 1,"img/13.jpg"));
    }

    @org.junit.Test
    public void queryBookById() {

        Book book = dao.queryBookById(3);
        System.out.println(book);
    }

    @org.junit.Test
    public void getBookList() {
        List<Book> bookList = dao.getBookList();
        for (Book b : bookList){
            System.out.println(b);
        }
    }

    @org.junit.Test
    public void queryPriceSearchTotalRecords() {
        int i = dao.queryPriceSearchTotalRecords(10, 20);
        System.out.println(i);
    }


    @org.junit.Test
    public void queryPriceSearchRecords() {
        List<Book> books = dao.queryPriceSearchRecords(1, 2, 10, 20);
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println(book);
        }
    }

}