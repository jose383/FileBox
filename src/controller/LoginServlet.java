package controller;

import javax.servlet.RequestDispatcher;
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

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");

        // Check Login
        if (user != null) {
            // User is already logged in
            response.sendRedirect("Home");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/view/Login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get user's info
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        // Validate with MySQL
        if (user.equals("asd") && password.equals("asd")){
            // Create Session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Redirect
            response.sendRedirect("Home");
            return;
        } else {
            // Error
            request.setAttribute("error", "Invalid username and/or password");
        }

        doGet(request, response);
    }
}
