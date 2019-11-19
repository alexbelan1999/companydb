package test.dao;

import java.util.List;

import test.Utility;
import dao.DaoException;
import dao.RolesDao;
import dao.fake.RolesDaoFakeImpl;
import company.Roles;

public class RolesDaoReadAllTest  {
    public static void main(String[] args) throws DaoException {
        RolesDao roleDao = new RolesDaoFakeImpl();
        List<Roles> roles = roleDao.readAll();
        System.out.println("Список всех ролей");
        System.out.println("===================");
        for(Roles role : roles) {
            System.out.println(Utility.toString(role));
        }
    }
}