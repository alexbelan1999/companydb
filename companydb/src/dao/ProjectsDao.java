package dao;

import java.util.List;
import company.Projects;

public interface ProjectsDao extends DAO<Projects> {
    List<Projects> readByProject(Long project_id) throws DaoException;
    List<Projects> readByCustomer(Long customer_id) throws DaoException;
    List<Projects> readByManager(Long manager_id) throws DaoException;
    List<Projects> readAll() throws DaoException;
}