package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");

        // Check Login
        if (user != null) {
            // User is already logged in
            response.sendRedirect("Home");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/view/Sign-Up.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Insert the record into the database
        Connection c = null;
        try
        {
            // Start connection with Database
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu115";
            String dbUsername = "cs3220stu115";
            String dbPassword = "G!jxS5!m";
            c = DriverManager.getConnection( url, dbUsername, dbPassword );

            // Insert to Database
            String sql = "INSERT INTO users (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setString(4, password);
            int numberOfRowsAffected = pstmt.executeUpdate();

            // Store Session
            HttpSession session = request.getSession();
            session.setAttribute("user", email);
        }
        catch(SQLException e)
        {
            throw new ServletException(e);
        }
        finally
        {
            try
            {
                if(c != null) c.close();
            }
            catch(SQLException e)
            {
                throw new ServletException(e);
            }
        }

        // Send the User (Client) back to Home
        response.sendRedirect("Home");
    }
}
