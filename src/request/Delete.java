package request;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIR = "uploads";

	public Delete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");


		// Get the path to the file and create a java.ioFile object
		String filename = request.getParameter("fileName");
		String path = getServletContext().getRealPath("WEB-INF/uploads") + "/" + user + "/" + filename;
		File file = new File(path);

		if (file.delete()){
            System.out.println("file deleted");
        } else {
			System.out.println("File not deleted");
		}


		response.sendRedirect("Home");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}