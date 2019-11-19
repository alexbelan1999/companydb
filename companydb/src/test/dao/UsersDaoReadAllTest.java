package test.dao;

import java.util.List;

import test.Utility;
import dao.DaoException;
import dao.UsersDao;
import dao.fake.UsersDaoFakeImpl;
import company.Users;

public class UsersDaoReadAllTest {
    public static void main(String[] args) throws DaoException {
        UsersDao userDao = new UsersDaoFakeImpl();
        List<Users> users = userDao.readAll();
        System.out.println("Список всех пользователей");
        System.out.println("===================");
        for(Users user : users) {
            System.out.println(Utility.toString(user));
        }
    }
}