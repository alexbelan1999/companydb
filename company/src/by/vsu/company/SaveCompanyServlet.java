package by.vsu.company;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.company.*;


@WebServlet("/SaveCompanyServlet")
public class SaveCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        Company object = new Company();
        
        object.setCname(req.getParameter("cname"));
        object.setAddress(req.getParameter("address"));
        
        try {
        	object.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        if(object.getId() == null) {
        	System.out.println("Добавление");
            Companies.insert(object);
        } else {
        	System.out.println("Обновление");
            Companies.update(object);
        }

        resp.sendRedirect(req.getContextPath() + "/index.html");
	}

}
