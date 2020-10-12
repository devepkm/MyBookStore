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

/**
 * @Auther: dev
 * @Date: 10/10/2020 17:41
 * @Description:
 */
public class ClientBookServlet extends BaseServlet {

    private BookService service = new BookServiceImpl();



    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);

        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = service.getPage(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/page/client/index.jsp").forward(req, resp);
        return;


    }


    protected void priceSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        Page<Book> page = service.getPriceSearchPage(pageNo, pageSize, min, max);
        page.setUrl("client/bookServlet?action=priceSearch&min=" + min + "&max=" + max);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/page/client/index.jsp").forward(req, resp);
        return;
    }


}
