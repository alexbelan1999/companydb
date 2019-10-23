package service;

import java.util.List;
import company.Projects;

public interface ProjectsService {
    List<Projects> findByCustomer(Long customer_id) throws ServiceException;
    List<Projects> findByManager(Long manager_id) throws ServiceException;
    List<Projects> findAll() throws ServiceException;
}