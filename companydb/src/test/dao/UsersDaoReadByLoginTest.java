package test.dao;

import java.util.List;
import dao.DaoException;
import test.Utility;
import dao.UsersDao;
import dao.fake.UsersDaoFakeImpl;
import company.Users;

public class UsersDaoReadByLoginTest {
    private static void output(UsersDao userDao, String login) throws DaoException {
        Users user = userDao.readByLogin(login);
        System.out.printf("Пользователей с логином [%s]:\n", login);
        System.out.println("================================================");
        System.out.println(Utility.toString(user));
        System.out.println();
    }

    public static void main(String[] args) throws DaoException {
        UsersDao userDao = new UsersDaoFakeImpl();
        output(userDao, "admin");
        output(userDao, "manager");
        output(userDao, "user");
    }
}