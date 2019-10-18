package dao.fake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import dao.ManagersDao;
import company.Managers;

public class ManagersDaoFakeImpl implements ManagersDao {
    
    private static Map<Long, Managers> managers = new ConcurrentHashMap<>();
    
    static {
        Managers manager = new Managers();
        manager.setId(1L);
        manager.setSurname("Иванов");
        manager.setName("Иван");
        manager.setPatronymic("Иванович");
        managers.put(manager.getId(), manager);
        manager = new Managers();
        manager.setId(2L);
        manager.setSurname("Петров");
        manager.setName("Петр");
        manager.setPatronymic("Петрович");
        managers.put(manager.getId(), manager);
        manager = new Managers();
        manager.setId(3L);
        manager.setSurname("Сидоров");
        manager.setName("Сидр");
        manager.setPatronymic("Сидорович");
        managers.put(manager.getId(), manager);
    }

    @Override
    public Long create(Managers manager) {
        Long id = 0L;
        if(!managers.isEmpty()) {
            id = Collections.max(managers.keySet());
        }
        manager.setId(++id);
        managers.put(id, manager);
        return id;
    }

    @Override
    public Managers read(Long id) {
        return managers.get(id);
    }

    @Override
    public void update(Managers manager) {
        managers.put(manager.getId(), manager);
    }

    @Override
    public void delete(Long id) {
        managers.remove(id);
    }

    @Override
    public List<Managers> readAll() {
        return new ArrayList<>(managers.values());
    }
    
    @Override
    public List<Managers> readByManager(Long manager_id) {
        List<Managers> result = new ArrayList<>();
        for(Managers manager : managers.values()) {
            if(manager.getId() == manager_id) {
                result.add(manager);
            }
        }
        return result;
    }
}