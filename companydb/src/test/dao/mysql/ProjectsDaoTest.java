package test.dao.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.DaoException;
import dao.mysql.ProjectsDaoMySqlImpl;
import company.*;
import pool.ConnectionPool;
import pool.PoolException;
import test.Utility;

public class ProjectsDaoTest {
    private static void output(List<Projects> projects, String method, String description) {
        System.out.printf("==================================================\nМетод %s()\nСписок проектов (%s)\n--------------------------------------------------\n", method, description);
        for(Projects project : projects) {
            System.out.println(Utility.toString(project));
        }
    }

    public static void main(String[] args) throws SQLException, PoolException, DaoException {
        ConnectionPool.getInstance().init("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            ProjectsDaoMySqlImpl projectDao = new ProjectsDaoMySqlImpl();
            projectDao.setConnection(connection);
            output(projectDao.readAll(), "readAll", "все проекты");
            output(projectDao.readByCustomer(1L), "readByCustomer", "все проекты 1 заказчика");
            output(projectDao.readByManager(1L), "readByManager", "все проекты 1 менеджера");
            Projects project1 = new Projects();
            project1.setCustomer(new Customers());
            project1.getCustomer().setId(1L);
            project1.setProject_name("Project1");
            project1.setStart_date("2001-01-01");
            project1.setPlan_end_date("2003-03-03");
            project1.setEnd_date("2002-02-02");
            project1.setManager(new Managers());
            project1.getManager().setId(1L);
            project1.setSuccess(1);
            Long id1 = projectDao.create(project1);
            System.out.printf("==================================================\nМетод create()\nПроект создан с идентификатором %d\n", id1);
            output(projectDao.readByCustomer(1L), "readByCustomer", "все проекты 1 заказчика");
            output(projectDao.readByManager(1L), "readByManager", "все проекты 1 менеджера");
            project1 = projectDao.read(id1);
            System.out.printf("==================================================\nМетод read()\nПрочитан проект с идентификатором %d\n--------------------------------------------------\n", id1);
            System.out.println(Utility.toString(project1));
            project1.setProject_name("!Project!");
            projectDao.update(project1);
            System.out.printf("==================================================\nМетод update()\nпроект с идентификатором %d обновлен\n", id1);
            output(projectDao.readAll(), "readAll", "все проекты");
            projectDao.delete(id1);
            System.out.printf("==================================================\nМетод delete()\nКнига с идентификатором %d удалена\n", id1);
            output(projectDao.readAll(), "readAll", "все проекты");
        }
        ConnectionPool.getInstance().destroy();
    }
}