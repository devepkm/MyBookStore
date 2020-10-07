package devepkm.dao;


import devepkm.bean.Book;

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
}
