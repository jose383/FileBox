package controller;

import model.ValidateSWE;

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
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate with Database
        if (ValidateSWE.checkUser(email, password)){
            // Create Session
            HttpSession session = request.getSession();
            session.setAttribute("user", email);

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
