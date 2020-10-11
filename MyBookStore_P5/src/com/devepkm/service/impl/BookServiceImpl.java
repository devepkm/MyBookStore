package com.devepkm.service.impl;

import com.devepkm.bean.Book;
import com.devepkm.bean.Page;
import com.devepkm.dao.BookDao;
import com.devepkm.dao.impl.BookDaoImpl;
import com.devepkm.service.BookService;

import java.util.List;

/**
 * @Auther: dev
 * @Date: 1/10/2020 12:41
 * @Description:
 */
public class BookServiceImpl implements BookService {

    private BookDao dao = new BookDaoImpl();

    @Override
    public int addBook(Book book) {
        return dao.addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return dao.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return dao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return dao.queryBookById(id);
    }

    @Override
    public List<Book> getBookList() {
        return dao.getBookList();
    }


    @Override
    public Page<Book> getPage(int pageNo, int pageSize) {


        Page<Book> page = new Page<>();

        page.setPageSize(pageSize);
        int totalRecords = dao.queryTotalRecords();
        page.setTotalRecord(totalRecords);

        int totalPageNo = (int) Math.ceil((double) totalRecords / pageSize);
        page.setTotalPageNo(totalPageNo);

        page.setPageNo(pageNo);

        List<Book> books = dao.queryPageRecords((page.getPageNo() - 1) * pageSize, pageSize);
        page.setRecords(books);
        return page;
    }

    @Override
    public Page<Book> getPriceSearchPage(int pageNo, int pageSize, int min, int max) {

        Page<Book> page = new Page<>();

        page.setPageSize(pageSize);
        int totalRecords = dao.queryPriceSearchTotalRecords(min, max);
        page.setTotalRecord(totalRecords);

        int totalPageNo = (int) Math.ceil((double) totalRecords / pageSize);
        page.setTotalPageNo(totalPageNo);

        page.setPageNo(pageNo);

        List<Book> books = dao.queryPriceSearchRecords((page.getPageNo() - 1) * pageSize, pageSize, min, max);
        page.setRecords(books);
        return page;
    }


}
