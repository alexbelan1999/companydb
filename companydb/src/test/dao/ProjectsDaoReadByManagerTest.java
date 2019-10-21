package test.dao;

import java.util.List;

import test.Utility;
import dao.ProjectsDao;
import dao.fake.ProjectsDaoFakeImpl;
import company.Projects;

public class ProjectsDaoReadByManagerTest {
    private static void output(ProjectsDao projectDao, Long manager_id) {
        List<Projects> projects = projectDao.readByManager(manager_id);
        System.out.printf("Список всех  проектов менеджера [%d]:\n", manager_id);
        System.out.println("================================================");
        for(Projects project : projects) {
            System.out.println(Utility.toString(project));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ProjectsDao projectsDao = new ProjectsDaoFakeImpl();
        output(projectsDao, 1L);
        output(projectsDao, 2L);
        output(projectsDao, 3L);
    }
}