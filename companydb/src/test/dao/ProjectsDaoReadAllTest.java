package test.dao;

import java.util.List;

import test.Utility;

import dao.ProjectsDao;
import dao.fake.ProjectsDaoFakeImpl;
import company.Projects;

public class ProjectsDaoReadAllTest {
    public static void main(String[] args) {
        ProjectsDao projectDao = new ProjectsDaoFakeImpl();
        List<Projects> projects = projectDao.readAll();
        System.out.println("Список всех проектов");
        System.out.println("===================");
        for(Projects project : projects) {
            System.out.println(Utility.toString(project));
        }
    }
}