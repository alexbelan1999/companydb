package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dao.DaoException;
import dao.RolesDao;
import dao.UsersDao;
import company.Users;
import company.Roles;

public class UsersServiceImpl implements UsersService {
    private RolesDao roleDao;
    private UsersDao userDao;
    
    public List<Users> findByRole(Long role_id) throws ServiceException {
        try {
            List<Users> users = userDao.readByRole(role_id);
            Map<Long, Roles> roles = new HashMap<>();
            for(Users user : users) {
                Roles role = user.getRole();
                if(role != null) {
                    Long id = role.getId();
                    role = roles.get(id);
                    if(role == null) {
                        role = roleDao.read(id);
                        roles.put(id, role);
                    }
                    user.setRole(role);
                }

            }
            return users;
            
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
        
               
    }
    
    public List<Users> findAll() throws ServiceException{
        try {
            return userDao.readAll();
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }
    
    @Override
    public Users findById(Long id) throws ServiceException {
        try {
            return userDao.read(id);
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }
    
    @Override
    public  Users findByLogin(String login) throws ServiceException {
        try {
            return userDao.readByLogin(login);
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(Users user) throws ServiceException {
        try {
            if(user.getId() != null) {
                userDao.update(user);
            } else {
                userDao.create(user);
            }
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            userDao.delete(id);
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }
    
    public void setRolesDao(RolesDao roleDao) {
        this.roleDao = roleDao;
    }
    
    public void setUsersDao(UsersDao userDao) {
        this.userDao = userDao;
    }
}
