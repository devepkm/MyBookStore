package com.devepkm.web;

import com.devepkm.bean.Book;
import com.devepkm.bean.Page;
import com.devepkm.service.BookService;
import com.devepkm.service.impl.BookServiceImpl;
import com.devepkm.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @Auther: dev
 * @Date: 5/10/2020 11:20
 * @Description:
 */
public class BookServlet extends BaseServlet {

    private BookService service = new BookServiceImpl();



    protected void add(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        Book book = WebUtils.injectBean(new Book(), req.getParameterMap());
        service.addBook(book);
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
//        pageNo++ to see if a new page is created, if the page is large than the totalPageNO, it will be handle in page() method -> setPageNo()
        pageNo++;

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
        return;



    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        service.deleteBookById(Integer.parseInt(id));

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
        return;


    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Book book = WebUtils.injectBean(new Book(), req.getParameterMap());
        service.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
        return;



    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = service.getBookList();
        req.setAttribute("booklist", bookList);

        req.getRequestDispatcher("/page/manager/book_manager.jsp").forward(req, resp);
        return;


    }

    protected void querybook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Book book = service.queryBookById(Integer.parseInt(id));
        req.setAttribute("book", book);
        req.getRequestDispatcher("/page/manager/book_edit.jsp").forward(req, resp);
        return;

    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);

        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = service.getPage(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        req.setAttribute("page", page);

        req.getRequestDispatcher("/page/manager/book_manager.jsp").forward(req, resp);

        return;



    }

}
