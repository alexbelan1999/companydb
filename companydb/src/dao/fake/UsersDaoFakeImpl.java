package dao.fake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import dao.UsersDao;
import company.*;

public class UsersDaoFakeImpl implements UsersDao {
    
    private static Map<Long, Users> users = new ConcurrentHashMap<>();

    static {
        Users user = new Users();
        user.setId(1L);
        user.setLogin("admin");
        user.setPassword("12345");
        user.setRole(new Roles());
        user.getRole().setId(1L);
        user.getRole().setRole("admin");
        users.put(user.getId(), user);
        user = new Users();
        user.setId(3L);
        user.setLogin("user");
        user.setPassword("123");
        user.setRole(new Roles());
        user.getRole().setId(3L);
        user.getRole().setRole("user");
        users.put(user.getId(), user);
        user = new Users();
        user.setId(2L);
        user.setLogin("manager");
        user.setPassword("1234");
        user.setRole(new Roles());
        user.getRole().setId(2L);
        user.getRole().setRole("manager");
        users.put(user.getId(), user);
        
    }

    @Override
    public Long create(Users user) {
        Long id = 0L;
        if(!users.isEmpty()) {
            id = Collections.max(users.keySet());
        }
        user.setId(++id);
        users.put(id, user);
        return id;
    }

    @Override
    public Users read(Long id) {
        return users.get(id);
    }

    @Override
    public void update(Users user) {
        users.put(user.getId(), user);
    }

    @Override
    public void delete(Long id) {
        users.remove(id);
    }

    @Override
    public List<Users> readAll() {
        return new ArrayList<>(users.values());
    }
    
    @Override
    public List<Users> readByRole(Long role_id) {
        List<Users> result = new ArrayList<>();
        for(Users user : users.values()) {
            if((role_id == null && user.getRole() == null) || (role_id != null && user.getRole() != null && role_id.equals(user.getRole().getId()))) {
                result.add(user);
            }
        }
        return result;
    }
    
    @Override
    public Users readByLogin(String login) {
        Users user = new Users();
        for(Users user1 : users.values()) {
            if (user1.getLogin().contains(login)) {
                user = user1;
                break;
            }
        }
        return user;
    }
}
