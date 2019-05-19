package controller;

import model.UploadDetail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");

        // Check Login
        if (user == null) {
            // User did not log in
            response.sendRedirect("Login");
            return;
        }

        handleRequest(request, response);
        request.getRequestDispatcher("/WEB-INF/view/Home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /***** Get The Absolute Path Of The Web Application *****/
        //String applicationPath = getServletContext().getRealPath(""),
        //uploadPath = applicationPath + File.separator + UPLOAD_DIR;
        // Output: /Users/Jose/WorkSpaces/JAVA/FileBox/out/artifacts/FileBox//uploads

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        String uploadPath = getServletContext().getRealPath("/WEB-INF/uploads") + "/" + user;

        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }

        UploadDetail details = null;
        File[] allFiles = fileUploadDirectory.listFiles();
        List<UploadDetail> fileList = new ArrayList<UploadDetail>();

        for (File file : allFiles) {
            details = new UploadDetail();
            details.setFileName(file.getName());
            details.setFileSize(file.length() / 1024);
            fileList.add(details);
        }

        request.setAttribute("uploads", fileList);
        // RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/AllFiles.jsp");
        //request.getRequestDispatcher("/WEB-INF/view/AllFiles.jsp").forward(request, response);
        //doGet(request, response);
        //dispatcher.forward(request, response);
    }



}
