package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean hasError = false;

        if (username == null || username.trim().length() == 0){
            hasError = true;
            request.setAttribute("usernameError", "Username can't be empty");
        }

        if (password == null || password.trim().length() == 0){
            hasError = true;
            request.setAttribute("passwordError", "Password can't be empty");
        }

        if (!hasError){
            // Insert the record into the database
            Connection c = null;
            try
            {
                // Start connection with Database
                String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu115";
                String dbUsername = "cs3220stu115";
                String dbPassword = "G!jxS5!m";
                c = DriverManager.getConnection( url, dbUsername, dbPassword );

                // Check for duplicate Username
                PreparedStatement ps;
                ps = c.prepareStatement("select username from users where username=?");
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();

                if (rs.next()){

                    // Found a Duplicate
                    request.setAttribute("usernameError", "This username is already taken!");

                } else {

                    // Insert to Database
                    ps = c.prepareStatement("INSERT INTO users (first_name, last_name, username, password) VALUES (?, ?, ?, ?)");
                    ps.setString(1, first_name);
                    ps.setString(2, last_name);
                    ps.setString(3, username);
                    ps.setString(4, password);
                    int numberOfRowsAffected = ps.executeUpdate();

                    // Store Session
                    HttpSession session = request.getSession();
                    session.setAttribute("user", username);
                }
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
        }

        doGet(request, response);
    }
}
