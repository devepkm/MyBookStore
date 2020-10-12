package com.devepkm.dao.impl;

import com.devepkm.bean.Book;
import com.devepkm.dao.BaseDao;
import com.devepkm.dao.BookDao;

import java.util.List;

/**
 * @Auther: dev
 * @Date: 1/10/2020 11:35
 * @Description:
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "INSERT into book(`name` , `author` , `price` , `sales` , `stock` , `img_path`) values (?,?,?,?,?,?) ";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());

    }

    @Override
    public int deleteBookById(int id) {
        String sql = "DELETE FROM book WHERE `id` = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {

        String sql = "UPDATE book set `name` = ? , `author` = ? , `price` = ? , `sales` = ? , `stock` = ? , `img_path` = ? WHERE `id` = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "SELECT `id`, `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath FROM book WHERE `id` = ?";
        return queryForOne(sql, id);
    }

    @Override
    public List<Book> getBookList() {
        String sql = "SELECT * FROM book";
        return queryForList(sql);
    }

    @Override
    public int queryTotalRecords() {
        String sql = "SELECT count(*) FROM book";
        return queryForSigleValue(sql, null);

    }


    @Override
    public List<Book> queryPageRecords(int begin, int pageSize) {
        String sql = "SELECT * FROM book limit ? , ?";
        return queryForList(sql, begin, pageSize);
    }

    @Override
    public List<Book> queryPriceSearchRecords(int begin, int pageSize, int min, int max) {
        String sql = "SELECT * FROM book WHERE Price  BETWEEN ? and  ? ORDER BY Price LIMIT ?, ?";
        return queryForList(sql, min, max, begin, pageSize);
    }

    @Override
    public int queryPriceSearchTotalRecords(int min, int max) {
        String sql = "SELECT count(*) FROM book WHERE Price  BETWEEN ? AND ?";
        return queryForSigleValue(sql, min, max);
    }


}
