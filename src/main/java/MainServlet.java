

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "main",urlPatterns = "/main")
public class MainServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(MainServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Some-Header", "Some value");

        req.setAttribute("header", "First Http Servlet");

        getServletContext().getRequestDispatcher("/page_header").include(req, resp);

        resp.getWriter().println("<h1>Привет от сервлета!</h1>");
        resp.getWriter().println("<p>contextPath: " + req.getContextPath() + "</p>");
        resp.getWriter().println("<p>servletPath: " + req.getServletPath() + "</p>");
        resp.getWriter().println("<p>pathInfo: " + req.getPathInfo() + "</p>");
        resp.getWriter().println("<p>queryString: " + req.getQueryString() + "</p>");
        resp.getWriter().println("<p>param1: " + req.getParameter("param1") + "</p>");
        resp.getWriter().println("<p>param2: " + req.getParameter("param2") + "</p>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
