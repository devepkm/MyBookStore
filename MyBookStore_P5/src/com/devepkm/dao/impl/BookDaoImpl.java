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
        String sql = "insert into book(`name` , `author` , `price` , `sales` , `stock` , `img_path`) values (?,?,?,?,?,?) ";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());

    }

    @Override
    public int deleteBookById(int id) {
        String sql = "DELETE FROM book WHERE `id` = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {

        String sql = "update book set `name` = ? , `author` = ? , `price` = ? , `sales` = ? , `stock` = ? , `img_path` = ? where `id` = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`, `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from book where `id` = ?";
        return queryForOne(sql, id);
    }

    @Override
    public List<Book> getBookList() {
        String sql = "select * from book";
        return queryForList(sql);
    }

    @Override
    public int queryTotalRecords() {
        String sql = "select count(*) from book";
        return queryForSigleValue(sql, null);

    }

    @Override
    public List<Book> queryPageRecords(int begin, int pageSize) {
        String sql = "select * from book limit " + begin + " , " + pageSize;
        return queryForList(sql, null);
    }


}
