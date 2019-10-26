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
import web.ActionResultType;

public class CustomersSaveActionImpl implements Action {
    private CustomersService service;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            Customers customer = getCustomer(req);
            try {
                service.save(customer);
                return new ActionResult("/customer/list.html");
            } catch(ServiceException e) {
                throw new ServletException(e);
            }
        } catch(IllegalArgumentException e) {
            req.setAttribute("message", e.getMessage());
            return new ActionResult("/error", ActionResultType.FORWARD);
        }
    }

    public void setCustomersService(CustomersService service) {
        this.service = service;
    }

    private Customers getCustomer(HttpServletRequest req) {
        Customers customer = new Customers();
        try {
            customer.setId(Long.parseLong(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        customer.setName(req.getParameter("name"));
        customer.setAddress(req.getParameter("adress"));
        customer.setTotal_pnumber(Integer.parseInt(req.getParameter("total_pnumber")));
        customer.setComplet_pnumber(Integer.parseInt(req.getParameter("complet_pnumber")));
        if(customer.getName() == null || customer.getName().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Имя\"");
        }
        if(customer.getAddress()== null || customer.getAddress().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Адрес\"");
        }
        if(customer.getTotal_pnumber() == null || customer.getTotal_pnumber().toString().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Количество проектов\"");
        }
        if(customer.getComplet_pnumber() == null || customer.getComplet_pnumber().toString().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Количество завершенных проектов\"");
        }
        return customer;
    }
}