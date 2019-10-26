package web.customers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.Customers;
import service.CustomersService;
import service.ServiceException;
import web.Action;
import web.ActionResult;

public class CustomersEditActionImpl implements Action {
    private CustomersService service;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = null;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch(NumberFormatException e) {}
        if(id != null) {
            try {
                Customers customer = service.findById(id);
                req.setAttribute("customer", customer);
            } catch(ServiceException e) {
                throw new ServletException(e);
            }
        }
        return null;
    }

    public void setCustomersService(CustomersService service) {
        this.service = service;
    }
}