import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Task task = (Task) request.getAttribute("task");
        response.setCharacterEncoding("UTF-8");
        PrintWriter w = response.getWriter();
        w.println("<HTML>");
        w.println("<HEAD>");
        w.println("<META http-equiv=\"Content-Type\"");
        w.println("      content=\"text/html; charset=UTF-8\">");
        w.println("<TITLE>Тест</TITLE>");
        w.println("</HEAD>");
        w.println("<BODY>");
        w.println("<FORM action=\"save.html\" method=\"post\">");
        if(task != null) {
            w.printf("<INPUT type=\"hidden\" name=\"id\" value=\"%d\">\n",
                    task.getId());
        }
        w.println("<P>Cipher:</P>");
        w.printf("<INPUT type=\"text\" name=\"cipher\" value=\"%s\">\n",
                task != null ? task.getCipher() : new String());
        w.println("<P>Project name:</P>");
        w.printf("<INPUT type=\"text\" name=\"project_name\" value=\"%s\">\n",
                task != null ? task.getProject_name() : new String());
        w.println("<P>Project description:</P>");
        w.printf("<INPUT type=\"text\" name=\"project_description\" value=\"%s\">\n",
                task != null ? task.getProject_description().toString() : new String());
        w.println("<P>Plan time:</P>");
        w.printf("<INPUT type=\"text\" name=\"plan_time\" value=\"%s\">\n",
                task != null ? task.getPlan_time() : new String());
        w.println("<P>Actual time:</P>");
        w.printf("<INPUT type=\"text\" name=\"actual_time\" value=\"%s\">\n",
                task != null ? task.getActual_time() : new String());
        w.println("<BUTTON type=\"submit\">Сохранить</BUTTON>");
        w.println("<A href=\"index.html\">Назад</A>");
        w.println("</FORM>");
        w.println("</BODY>");
        w.println("</HTML>");
    }
}
