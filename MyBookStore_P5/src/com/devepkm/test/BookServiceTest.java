package com.devepkm.test;

import com.devepkm.bean.Book;
import com.devepkm.bean.Page;
import com.devepkm.service.BookService;
import com.devepkm.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: dev
 * @Date: 1/10/2020 12:43
 * @Description:
 */
public class BookServiceTest {
    BookService service = new BookServiceImpl();

    @Test
    public void addBook() {
        service.addBook(new Book("adfdfafdadfs", "adfads", new BigDecimal(334.2), 5, 5, "dgfs.jph"));

    }

    @Test
    public void deleteBookById() {
        service.deleteBookById(5);

    }

    @Test
    public void updateBook() {
        service.updateBook(new Book(1,"javhgja", "me", new BigDecimal(12.35), 34, 1,"img/13.jpg"));

    }

    @Test
    public void queryBookById() {

        Book book = service.queryBookById(3);
        System.out.println(book);
    }

    @Test
    public void getBookList() {
        List<Book> bookList = service.getBookList();
        for (Book b : bookList){
            System.out.println(b);
        }
    }

    @Test
    public void getPage() {
        Page<Book> page = service.getPage(3, 4);
        List<Book> records = page.getRecords();
        for (int i = 0; i < records.size(); i++) {
            System.out.println(records);
        }

    }

    @Test
    public void getPriceSearchPage() {
        Page<Book> page = service.getPriceSearchPage(1, 4, 10, 20);
        List<Book> records = page.getRecords();
        for (Book b : records){
            System.out.println(b);
        }

    }



}