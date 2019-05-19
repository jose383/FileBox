package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIR = "uploads";

	public Delete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String fileName = request.getParameter("fileName"), applicationPath = getServletContext().getRealPath(""),
				downloadPath = applicationPath + File.separator + UPLOAD_DIR,
				filePath = downloadPath + File.separator + fileName;
		File file = new File(filePath);
        if(file.delete()){
            System.out.println("file deleted");
        }else System.out.println("File not deleted");
        
        
		response.sendRedirect("UploadedFiles");

       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}