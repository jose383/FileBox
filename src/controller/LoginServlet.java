package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/Login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        // Get user's info
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        // Validate with MySQL
        if (user.equals("abc") && password.equals("123")){
            // Create Session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Redirect
            response.sendRedirect("index.jsp");
        } else {
            // Print or redirect to Login Error page
            //out.println("Wrong Username or password");
        }
    }
}
