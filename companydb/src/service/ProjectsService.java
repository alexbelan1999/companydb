package service;

import java.util.List;
import company.Projects;

public interface ProjectsService {
    List<Projects> findByProject(Long project_id);
    List<Projects> findByCustomer(Long customer_id);
    List<Projects> findByManager(Long manager_id);
    List<Projects> findAll();
}