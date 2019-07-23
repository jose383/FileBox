package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@WebServlet("/Rename")
public class Rename extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Rename() {
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

		boolean hasError = false;
		String newName = request.getParameter("newName");
		if (newName == null || newName.trim().length() == 0){
			hasError = true;
		}

		if (hasError){
			response.sendRedirect("RenameView?hasError=true&fileName=" + request.getParameter("fileName"));
			return;
		}

		// Get the path to the file and create a java.ioFile object
		String filename = request.getParameter("fileName");
		String path = getServletContext().getRealPath("WEB-INF/uploads") + "/" + user + "/";
		File file = new File(path + filename);


		//Rename file
		File newFile = new File(path + newName);
		if(file.renameTo(newFile)){
			System.out.println("File Rename Success!");;
		}else{
			System.out.println("File Rename Failed!");
		}

		response.sendRedirect("Home");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}