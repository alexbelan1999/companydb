package by.vsu.project;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.project.*;


@WebServlet("/SaveProjectServlet")
public class SaveProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        Project object = new Project();
        
        object.setCompanyid(Integer.parseInt(req.getParameter("companyid")));
        object.setPname(req.getParameter("pname"));
	    object.setStartdate(req.getParameter("startdate"));
	    object.setPlanenddate(req.getParameter("planenddate"));
	    object.setEnddate(req.getParameter("enddate"));
	    object.setManagerid(Integer.parseInt(req.getParameter("managerid")));
	    object.setSuccess(req.getParameter("success") != null ? req.getParameter("success").equals("on") : false);
	        
	       
	    try {
            object.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        if(object.getId() == null) {
            Projects.insert(object);
        } else {
            Projects.update(object);
        }

        resp.sendRedirect(req.getContextPath() + "/index.html");
	}

}
