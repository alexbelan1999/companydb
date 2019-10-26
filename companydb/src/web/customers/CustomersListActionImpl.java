package web.customers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.Customers;
import service.CustomersService;
import service.ServiceException;
import web.Action;
import web.ActionResult;

public class CustomersListActionImpl implements Action {
    private CustomersService service;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Customers> customers = service.findAll();
            req.setAttribute("customers", customers);
            return null;
        } catch(ServiceException e) {
            throw new ServletException(e);
        }
    }

    public void setCustomersService(CustomersService service) {
        this.service = service;
    }
}