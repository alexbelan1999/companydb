package test.dao;

import java.util.List;

import test.Utility;

import dao.ManagersDao;
import dao.fake.ManagersDaoFakeImpl;
import company.Managers;

public class ManagersDaoReadAllTest {
    public static void main(String[] args) {
        ManagersDao managerDao = new ManagersDaoFakeImpl();
        List<Managers> managers = managerDao.readAll();
        System.out.println("Список всех менеджеров");
        System.out.println("===================");
        for(Managers manager : managers) {
            System.out.println(Utility.toString(manager));
        }
    }
}