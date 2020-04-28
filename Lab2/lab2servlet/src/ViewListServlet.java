import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
        Collection<Task> tasks = (Collection<Task>)request.getAttribute("tasks");
		Collection<String> str = (Collection<String>)request.getAttribute("str");
        response.setCharacterEncoding("UTF-8");
        PrintWriter w = response.getWriter();
        w.println("<HTML>");
        w.println("<HEAD>");
        w.println("<META http-equiv=\"Content-Type\"");
        w.println("      content=\"text/html; charset=UTF-8\">");
        w.println("<TITLE>Проекты</TITLE>");
        w.println("<STYLE>");
        w.println("TABLE {");
        w.println("border-collapse: collapse;");
        w.println("}");
        w.println("TH, TD {");
        w.println("border: 1px solid black;");
        w.println("padding: 5px 30px 5px 10px;");
        w.println("}");
        w.println("</STYLE>");
        w.println("</HEAD>");
        w.println("<BODY>");
        w.println("<FORM action=\"delete.html\" method=\"post\">");
        w.println("<TABLE>");
        w.print("<TR>");
        w.print("<TH>&nbsp;</TH>");
        w.print("<TH>Cipher</TH>");
        w.print("<TH>Project name</TH>");
        w.print("<TH>Project description</TH>");
        w.print("<TH>Plan time</TH>");
        w.print("<TH>Actual time</TH>");
        w.print("<TH>Lag</TH>");
        w.println("</TR>");
        for(Task task : tasks) {
            w.print("<TR>");
            w.printf("<TD>");
            w.printf("<INPUT type=\"checkbox\" name=\"id\" value=\"%d\">",
                    task.getId());
            w.printf("</TD>");
            w.printf("<TD><A href=\"edit.html?id=%d\">%s</A></TD>",
                    task.getId(), task.getCipher());
            w.printf("<TD>%s</TD>", task.getProject_name());
            w.printf("<TD>%s</TD>", task.getProject_description());
            w.printf("<TD>%s</TD>", Integer.toString(task.getPlan_time()));
            w.printf("<TD>%s</TD>", Integer.toString(task.getActual_time()));
            w.printf("<TD>%s</TD>", Integer.toString(task.getLag()));
            w.println("</TR>");
        }
        w.println("</TABLE>");
        w.println("<P>");
        w.println("<A href=\"edit.html\">Добавить</A>");
        w.println("<BUTTON type=\"submit\">Удалить</BUTTON>");
        w.println("</P>");
        w.println("</FORM>");
        w.println("<TABLE>");
        w.print("<TR>");
        w.print("<TD>Проекты с наибольшим отставанием:</TD>");
        w.print("</TR>");
        for (String s : str) {
            w.print("<TR>");
            w.printf("<TD>%s</TD>", s);
            w.println("</TR>");
        }
        w.println("</BODY>");
        w.println("</HTML>");
    }
}
