package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.CustomersDao;
import dao.ManagersDao;
import dao.ProjectsDao;
import company.Customers;
import company.Managers;
import company.Projects;

public class ProjectsServiceImpl implements ProjectsService {
    private CustomersDao customerDao;
    private ManagersDao managerDao;
    private ProjectsDao projectDao;

    @Override
    public List<Projects> findByProject(Long project_id) {
        List<Projects> projects = projectDao.readByProject(project_id);
        Map<Long, Customers> customers = new HashMap<>();
        Map<Long, Managers> managers = new HashMap<>();
        for(Projects project : projects) {
            Customers customer = project.getCustomer();
            Managers manager = project.getManager();

            if(customer != null) {
                Long id = customer.getId();
                customer = customers.get(id);
                if(customer == null) {
                    customer = customerDao.read(id);
                    customers.put(id, customer);
                }
                project.setCustomer(customer);
            }

            if(manager != null) {
                Long id = manager.getId();
                manager = managers.get(id);
                if(manager == null) {
                    manager = managerDao.read(id);
                    managers.put(id, manager);
                }
                project.setManager(manager);
            }
        }
        return projects;
    }
    
    public List<Projects> findByCustomer(Long customer_id) {
        List<Projects> projects = projectDao.readByCustomer(customer_id);
        Map<Long, Customers> customers = new HashMap<>();
        for(Projects project : projects) {
            Customers customer = project.getCustomer();

            if(customer != null) {
                Long id = customer.getId();
                customer = customers.get(id);
                if(customer == null) {
                    customer = customerDao.read(id);
                    customers.put(id, customer);
                }
                project.setCustomer(customer);
            }

        }
        return projects;
    }
    
    public List<Projects> findByManager(Long manager_id) {
        List<Projects> projects = projectDao.readByManager(manager_id);
        Map<Long, Managers> managers = new HashMap<>();
        for(Projects project : projects) {
            Managers manager = project.getManager();

            if(manager != null) {
                Long id = manager.getId();
                manager = managers.get(id);
                if(manager == null) {
                    manager = managerDao.read(id);
                    managers.put(id, manager);
                }
                project.setManager(manager);
            }
        }
        return projects;
    }
    
    public List<Projects> findAll() {
        return projectDao.readAll();
    }
    
    public void setCustomersDao(CustomersDao customerDao) {
        this.customerDao = customerDao;
    }

    public void setManagersDao(ManagersDao managerDao) {
        this.managerDao = managerDao;
    }
    
    public void setProjectsDao(ProjectsDao projectDao) {
        this.projectDao = projectDao;
    }
}
