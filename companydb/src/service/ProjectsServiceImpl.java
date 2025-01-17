package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dao.DaoException;
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
    
    public List<Projects> findByCustomer(Long customer_id) throws ServiceException {
        try {
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
            
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
        
               
    }
    
    public List<Projects> findByManager(Long manager_id) throws ServiceException {
        try {
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
            
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
        
    }
    
    public List<Projects> findAll() throws ServiceException{
        try {
            return projectDao.readAll();
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }
    
    @Override
    public Projects findById(Long id) throws ServiceException {
        try {
            return projectDao.read(id);
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(Projects project) throws ServiceException {
        try {
            if(project.getId() != null) {
                projectDao.update(project);
            } else {
                projectDao.create(project);
            }
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            projectDao.delete(id);
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
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
