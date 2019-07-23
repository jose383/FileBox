package response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");

		// Check Login
		if (user == null) {
			// User is already logged in
			response.sendRedirect("Home");
			return;
		}

		// Get the path to the file and create a java.ioFile object
		String filename = request.getParameter("fileName");
		String path = getServletContext().getRealPath("WEB-INF/uploads") + "/" + user + "/" + filename;
		File file = new File(path);

		// Set the response headers. File.length() returns the size of the file
		// as long, which we need to convert to a String
		response.setContentType( "application/octet-stream" );
		response.setHeader( "Content-Disposition", "attachment; filename=" + filename );

		// Binary files need to read/written in bytes,
		FileInputStream in = new FileInputStream( file );
		OutputStream out = response.getOutputStream();
		byte buffer[] = new byte[2048];
		int bytesRead;
		while( (bytesRead = in.read( buffer )) > 0 )
			out.write( buffer, 0, bytesRead );
		in.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
