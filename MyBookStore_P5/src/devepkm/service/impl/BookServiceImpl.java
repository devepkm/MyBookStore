package devepkm.service.impl;


import devepkm.bean.Book;
import devepkm.dao.BookDao;
import devepkm.dao.impl.BookDaoImpl;
import devepkm.service.BookService;

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
}
