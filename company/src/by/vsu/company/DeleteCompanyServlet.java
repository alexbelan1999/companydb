package by.vsu.company;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.company.*;

@WebServlet("/DeleteCompany")

public class DeleteCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            Companies.delete(Integer.parseInt(id));
        } catch(NumberFormatException e) {}
    
        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}
