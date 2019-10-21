package test.service;

import ioc.IoCConfigurer;
import ioc.IoCContainer;
import ioc.IoCException;

import java.util.List;

import service.ManagersService;
import test.Utility;
import company.Managers;

public class ManagersServiceFindAllTest {
    public static void main(String[] args) throws IoCException {
        IoCConfigurer.configure();
        IoCContainer ioc = new IoCContainer();
        ManagersService managerService = ioc.get(ManagersService.class);
        List<Managers> managers = managerService.findAll();
        System.out.println("Список всех менеджеров");
        System.out.println("===================");
        for(Managers manager : managers) {
            System.out.println(Utility.toString(manager));
        }
    }
}