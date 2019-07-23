package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
            // Validate with Database
            if (ValidateSWE.checkUser(username, password)){
                // Create Session
                HttpSession session = request.getSession();
                session.setAttribute("user", username);

                // Redirect
                response.sendRedirect("Home");
                return;
            } else {
                // Error
                request.setAttribute("loginError", "Invalid username and/or password");
            }
        }

        doGet(request, response);
    }
}
