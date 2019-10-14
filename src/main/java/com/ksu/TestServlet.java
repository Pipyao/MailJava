package com.ksu;

import org.omg.CORBA.Request;
import sun.security.jgss.HttpCaller;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String mail = request.getParameter("mail");
        String mess = request.getParameter("mess");

        try {

            writer.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "    <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<form class=\"decor\" action=\"test\" method=\"GET\">\n" +
                    "    <div class=\"form-inner\">\n" +
                    "        <h3>Мы свяжемся с тобой!</h3>\n" +
                    "    </div>\n" +
                    "</form>\n" +
                    "</body>\n" +
                    "</html>");
            SendEmail Mail = new SendEmail();
            Mail.Send(mail,first,last, mess);

        } finally {
            writer.close();
        }
    }
}