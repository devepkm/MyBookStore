package com.devepkm.test;

import com.devepkm.bean.Book;
import com.devepkm.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: dev
 * @Date: 8/10/2020 23:49
 * @Description:
 */
public class BaseDaoTest {
    BookDaoImpl bookDao = new BookDaoImpl();

    @Test
    public void queryForSigleValue() {
        String sql = "select count(*) from book";
        int i = bookDao.queryForSigleValue(sql, null);
        System.out.println(i);
    }


    @Test
    public void queryPageRecords() {

        String sql = "select * from book limit " + 8 + " , " + 4;
        List<Book> books = bookDao.queryForList(sql, null);
        for (Book book : books){
            System.out.println(book);
        }


    }
}