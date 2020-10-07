package devepkm.service;


import devepkm.bean.Book;

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

}
