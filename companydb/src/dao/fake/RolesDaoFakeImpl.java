package dao.fake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import dao.RolesDao;
import company.Roles;

public class RolesDaoFakeImpl implements RolesDao {
    
    private static Map<Long, Roles> roles = new ConcurrentHashMap<>();
    
    static {
        Roles role = new Roles();
        role.setId(1L);
        role.setRole("admin");
        roles.put(role.getId(), role);
        role = new Roles();
        role.setId(2L);
        role.setRole("manager");
        roles.put(role.getId(), role);
        role = new Roles();
        role.setId(3L);
        role.setRole("user");
        roles.put(role.getId(), role);
        
    }

    @Override
    public Long create(Roles role) {
        Long id = 0L;
        if(!roles.isEmpty()) {
            id = Collections.max(roles.keySet());
        }
        role.setId(++id);
        roles.put(id, role);
        return id;
    }

    @Override
    public Roles read(Long id) {
        return roles.get(id);
    }

    @Override
    public void update(Roles role) {
        roles.put(role.getId(), role);
    }

    @Override
    public void delete(Long id) {
        roles.remove(id);
    }

    @Override
    public List<Roles> readAll() {
        return new ArrayList<>(roles.values());
    }
    
}