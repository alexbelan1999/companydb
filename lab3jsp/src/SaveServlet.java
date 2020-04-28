import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pckg.*;
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
        Task task = new Task();
        task.setCipher(request.getParameter("cipher"));
        task.setProject_name(request.getParameter("project_name"));
        task.setProject_description(request.getParameter("project_description"));
        task.setPlan_time(Integer.parseInt(request.getParameter("plan_time")));
        task.setActual_time(Integer.parseInt(request.getParameter("actual_time")));
        task.setLag();
        try {
            task.setId(Integer.parseInt(request.getParameter("id")));
        } catch(NumberFormatException e) {}
        if(task.getId() == 0) {
            Storage.create(task);
        } else {
            Storage.update(task);
        }

        response.sendRedirect(request.getContextPath() + "/index.html");
        
    }

}
