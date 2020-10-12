package com.devepkm.dao;

import com.devepkm.bean.Book;

import java.util.List;

/**
 * @Auther: dev
 * @Date: 1/10/2020 11:29
 * @Description:
 */
public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(int id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> getBookList();

    public int queryTotalRecords();

    public List<Book> queryPageRecords(int begin, int pageSize);


    public List<Book> queryPriceSearchRecords(int begin, int pageSize, int min, int max);


    public int queryPriceSearchTotalRecords(int min, int max);
}
