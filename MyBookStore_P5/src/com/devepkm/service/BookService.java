package com.devepkm.service;

import com.devepkm.bean.Book;
import com.devepkm.bean.Page;

import java.util.List;

/**
 * @Auther: dev
 * @Date: 1/10/2020 12:39
 * @Description:
 */
public interface BookService {


    public int addBook(Book book);

    public int deleteBookById(int id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> getBookList();

    public Page<Book> getPage(int pageNo, int pageSize);


    Page<Book> getPriceSearchPage(int pageNo, int pageSize, int min, int max);
}
