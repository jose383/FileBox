package request;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/Upload")
public class Upload extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");

        // Check Login
        if (user == null) {
            // User is already logged in
            response.sendRedirect("Home");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/view/Upload.jsp").forward(request, response);
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        
        File repository = (File) servletContext.getAttribute( "javax.servlet.context.tempdir" );
        
        factory.setRepository( repository );

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload( factory );

        // Count how many files are uploaded
        int count = 0;
        
        // The directory we want to save the uploaded files to.
        String fileDir = getServletContext().getRealPath( "/WEB-INF/uploads" ) + "/" + user;

        // Parse the request
        try
        {
            List<FileItem> items = upload.parseRequest(request);

            // Check if Folder does not exist, then Create it
            File folder = new File(fileDir);
            if ( !folder.exists() ){
                folder.mkdirs();
            }



            for( FileItem item : items )
            {
                // If the item is not a form field - meaning it's an uploaded
                // file, we save it to the target dir
                if (!item.isFormField()) {
                    if (item.getName() == null || item.getName().isEmpty() || item.getSize() == 0) {
                        // No file was selected
                        request.setAttribute("fileError","No file was selected!");

                        // Forward to Upload.jsp
                        request.getRequestDispatcher("/WEB-INF/view/Upload.jsp").forward(request, response);
                    } else {
                        // item.getName() will return the full path of the uploaded
                        // file, e.g. "C:/My Documents/files/test.txt", but we only
                        // want the file name part, which is why we first create a
                        // File object, then use File.getName() to get the file
                        // name.
                        // /var/usr/some/temp/dir/some-file.jpg
                        // /user/albert/3220/WEB-INF/uploads   some-file.jpg
                        String fileName = (new File( item.getName() )).getName();
                        File file = new File( fileDir, fileName );
                        item.write( file );
                        ++count;
                    }
                }
            }
        }
        catch( Exception e )
        {
            throw new IOException( e );
        }

        request.setAttribute("count", count);
        request.setAttribute("fileDir", fileDir);

        request.getRequestDispatcher("/WEB-INF/view/Success.jsp").forward(request, response);
    }

}