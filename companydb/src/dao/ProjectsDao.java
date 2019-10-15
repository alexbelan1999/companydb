package dao;

import java.util.List;
import company.Projects;

public interface ProjectsDao extends DAO<Projects> {
    List<Projects> readByProject(Long project_id);
    List<Projects> readAll();
}