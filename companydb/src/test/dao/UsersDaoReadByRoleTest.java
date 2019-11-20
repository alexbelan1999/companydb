package test.dao;

import java.util.List;
import dao.DaoException;
import test.Utility;
import dao.UsersDao;
import dao.fake.ProjectsDaoFakeImpl;
import dao.fake.UsersDaoFakeImpl;
import company.Users;

public class UsersDaoReadByRoleTest {
    private static void output(UsersDao userDao, Long role_id) throws DaoException {
        List<Users> users = userDao.readByRole(role_id);
        System.out.printf("Список всех  пользователей с ролью [%d]:\n", role_id);
        System.out.println("================================================");
        for(Users user : users) {
            System.out.println(Utility.toString(user));
        }
        System.out.println();
    }

    public static void main(String[] args) throws DaoException {
        UsersDao userDao = new UsersDaoFakeImpl();
        output(userDao, 1L);
        output(userDao, 2L);
        output(userDao, 3L);
    }
}