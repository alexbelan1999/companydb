package test.dao;

import java.util.List;
import dao.DaoException;
import test.Utility;
import dao.ProjectsDao;
import dao.fake.ProjectsDaoFakeImpl;
import company.Projects;

public class ProjectsDaoReadByCustomerTest {
    private static void output(ProjectsDao projectDao, Long customer_id) throws DaoException {
        List<Projects> projects = projectDao.readByCustomer(customer_id);
        System.out.printf("Список всех  проектов заказчика [%d]:\n", customer_id);
        System.out.println("================================================");
        for(Projects project : projects) {
            System.out.println(Utility.toString(project));
        }
        System.out.println();
    }

    public static void main(String[] args) throws DaoException {
        ProjectsDao projectsDao = new ProjectsDaoFakeImpl();
        output(projectsDao, 1L);
        output(projectsDao, 2L);
        output(projectsDao, 3L);
    }
}