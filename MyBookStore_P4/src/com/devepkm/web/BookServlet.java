package com.devepkm.web;

import com.devepkm.bean.Book;
import com.devepkm.service.BookService;
import com.devepkm.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Auther: dev
 * @Date: 5/10/2020 11:20
 * @Description:
 */
public class BookServlet extends BaseServlet {

    BookService service = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) {
        List<Book> bookList = service.getBookList();
        req.setAttribute("booklist", bookList);


    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) {
        List<Book> bookList = service.getBookList();
        req.setAttribute("booklist", bookList);


    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) {
        List<Book> bookList = service.getBookList();
        req.setAttribute("booklist", bookList);


    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = service.getBookList();
        req.setAttribute("booklist", bookList);

        req.getRequestDispatcher("/page/manager/book_manager.jsp").forward(req, resp);


    }

}
