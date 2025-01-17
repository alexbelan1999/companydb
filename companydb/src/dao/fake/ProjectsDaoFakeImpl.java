package dao.fake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import dao.ProjectsDao;
import company.*;

public class ProjectsDaoFakeImpl implements ProjectsDao {
    
    private static Map<Long, Projects> projects = new ConcurrentHashMap<>();

    static {
        Projects project = new Projects();
        project.setId(1L);
        project.setProject_name("Test1");
        project.setStart_date("2010-10-10");
        project.setPlan_end_date("2010-11-12");
        project.setEnd_date("2010-11-11");
        project.setCustomer(new Customers());
        project.getCustomer().setId(1L);
        project.getCustomer().setName("Lacit");
        project.getCustomer().setAddress("ул. Лазо 149");
        project.getCustomer().setTotal_pnumber(0);
        project.getCustomer().setComplet_pnumber(0);
        project.setManager(new Managers());
        project.getManager().setId(1L);
        project.getManager().setSurname("Иванов");
        project.getManager().setName("Иван");
        project.getManager().setPatronymic("Иванович");
        project.setSuccess(1);
        projects.put(project.getId(), project);
        project = new Projects();
        project.setId(2L);
        project.setProject_name("Test2");
        project.setStart_date("2011-11-11");
        project.setPlan_end_date("2011-12-23");
        project.setEnd_date("2011-12-20");
        project.setCustomer(new Customers());
        project.getCustomer().setId(2L);
        project.getCustomer().setName("EPAM");
        project.getCustomer().setAddress("проспект Строителей 11A");
        project.getCustomer().setTotal_pnumber(0);
        project.getCustomer().setComplet_pnumber(0);
        project.setManager(new Managers());
        project.getManager().setId(2L);
        project.getManager().setSurname("Петров");
        project.getManager().setName("Петр");
        project.getManager().setPatronymic("Петрович");
        project.setSuccess(1);
        projects.put(project.getId(), project);
        project = new Projects();
        project.setId(3L);
        project.setProject_name("Test3");
        project.setStart_date("2012-12-12");
        project.setPlan_end_date("2013-01-28");
        project.setEnd_date("2016-06-06");
        project.setCustomer(new Customers());
        project.getCustomer().setId(3L);
        project.getCustomer().setName("iTechArt");
        project.getCustomer().setAddress("Коммунистическая ул. 16");
        project.getCustomer().setTotal_pnumber(0);
        project.getCustomer().setComplet_pnumber(0);
        project.setManager(new Managers());
        project.getManager().setId(3L);
        project.getManager().setSurname("Сидоров");
        project.getManager().setName("Сидр");
        project.getManager().setPatronymic("Сидорович");
        project.setSuccess(0);
        projects.put(project.getId(), project);
    }

    @Override
    public Long create(Projects project) {
        Long id = 0L;
        if(!projects.isEmpty()) {
            id = Collections.max(projects.keySet());
        }
        project.setId(++id);
        projects.put(id, project);
        return id;
    }

    @Override
    public Projects read(Long id) {
        return projects.get(id);
    }

    @Override
    public void update(Projects project) {
        projects.put(project.getId(), project);
    }

    @Override
    public void delete(Long id) {
        projects.remove(id);
    }

    @Override
    public List<Projects> readAll() {
        return new ArrayList<>(projects.values());
    }
    
    @Override
    public List<Projects> readByCustomer(Long customer_id) {
        List<Projects> result = new ArrayList<>();
        for(Projects project : projects.values()) {
            if((customer_id == null && project.getCustomer() == null) || (customer_id != null && project.getCustomer() != null && customer_id.equals(project.getCustomer().getId()))) {
                result.add(project);
            }
        }
        return result;
    }
    
    @Override
    public List<Projects> readByManager(Long manager_id) {
        List<Projects> result = new ArrayList<>();
        for(Projects project : projects.values()) {
            if((manager_id == null && project.getManager() == null) || (manager_id != null && project.getManager() != null && manager_id.equals(project.getManager().getId()))) {
                result.add(project);
            }
        }
        return result;
    }
}
