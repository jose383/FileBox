package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@WebServlet("/RenameView")
public class RenameView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIR = "uploads";

	public RenameView() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");

		// Check Login
		if (user == null) {
			// User did not log in
			response.sendRedirect("Login");
			return;
		}

		//request.setAttribute("fileName", request.getAttribute("fileName"));
		request.getRequestDispatcher("/WEB-INF/view/Rename.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}