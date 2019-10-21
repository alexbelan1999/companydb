package test.service;

import ioc.IoCConfigurer;
import ioc.IoCContainer;
import ioc.IoCException;

import java.util.List;

import service.CustomersService;
import test.Utility;
import company.Customers;

public class CustomersServiceFindAllTest {
    public static void main(String[] args) throws IoCException {
        IoCConfigurer.configure();
        IoCContainer ioc = new IoCContainer();
        CustomersService customerService = ioc.get(CustomersService.class);
        List<Customers> customers = customerService.findAll();
        System.out.println("Список всех заказчиков");
        System.out.println("===================");
        for(Customers customer : customers) {
            System.out.println(Utility.toString(customer));
        }
    }
}