package by.vsu.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.project.*;


@WebServlet("/GetEndProjectForCompany")


public class GetEndProjectForCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int companyid = Integer.parseInt(req.getParameter("company_id"));
		System.out.println(companyid);
        ArrayList<Project> objects = Projects.getProjectForCompany(companyid);
        System.out.println(objects);
        req.setAttribute("objects", objects);
        getServletContext().getRequestDispatcher("/view/projects.jsp")
                                                      .forward(req, resp);

    }

}