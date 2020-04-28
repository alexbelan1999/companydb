package by.vsu;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        MyObject object = (MyObject)req.getAttribute("object");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter w = resp.getWriter();
        w.println("<HTML>");
        w.println("<HEAD>");
        w.println("<META http-equiv=\"Content-Type\"");
        w.println("      content=\"text/html; charset=UTF-8\">");
        w.println("<TITLE>Тест</TITLE>");
        w.println("</HEAD>");
        w.println("<BODY>");
        w.println("<FORM action=\"save.html\" method=\"post\">");
        if(object != null) {
            w.printf("<INPUT type=\"hidden\" name=\"id\" value=\"%d\">\n",
                                               object.getId());
        }
        w.println("<P>Поле A:</P>");
        w.printf("<INPUT type=\"text\" name=\"field-a\" value=\"%s\">\n",
                      object != null ? object.getFieldA() : new String());
        w.println("<P>Поле B:</P>");
        w.printf("<INPUT type=\"text\" name=\"field-b\" value=\"%s\">\n",
           object != null ? object.getFieldB().toString() : new String());
        w.println("<P><INPUT type=\"checkbox\" name=\"field-c\""
              + " value=\"value\"" + (object != null && object.getFieldC()
                          ? " checked" : new String()) + "> Поле C.</P>");
        w.println("<BUTTON type=\"submit\">Сохранить</BUTTON>");
        w.println("<A href=\"index.html\">Назад</A>");
        w.println("</FORM>");
        w.println("</BODY>");
        w.println("</HTML>");
    }
}