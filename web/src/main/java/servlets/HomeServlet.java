package servlets;

import dtos.BookDto;
import service.BookService;
import service.IBookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {

    IBookService bookService = new BookService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String bookId = request.getParameter("choice");
        switch (action){
            case "Add": response.sendRedirect("/AddBookServlet");
            break;
            case "Edit": response.sendRedirect("/EditBookServlet?bookId="+bookId);
            break;
            case "Show": response.sendRedirect("/ShowBookServlet?bookId="+bookId);
            break;
            case "Delete": response.sendRedirect("/DeleteBookServlet?bookId="+bookId);
            break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookDto> bookDtos = bookService.findAll();
        request.setAttribute("books", bookDtos);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
