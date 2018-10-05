package A402.controller.utils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "ImageGetter", urlPatterns = "/ImageGetter")
public class ImageGetter extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String IMAGES_FOLDER = File.separator + "opt" + File.separator + "tomcat" + File.separator
            + "images";
    public ImageGetter() {
        super();

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String link_ofImage = request.getParameter("link_ofImage");
        String extension = "";

        int i = link_ofImage.lastIndexOf('.');
        if (i > 0) {
            extension = link_ofImage.substring(i+1);
        }
        response.setContentType("image/"+extension);

        File f = new File(IMAGES_FOLDER + File.separator + link_ofImage);
        if(f == null){
            return;
        }
        BufferedImage bi = ImageIO.read(f);
        OutputStream out = response.getOutputStream();
        ImageIO.write(bi, extension, out);
        out.close();
    }
}
