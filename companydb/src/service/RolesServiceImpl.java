package service;

import java.util.List;

import dao.RolesDao;
import dao.DaoException;
import company.Roles;

public class RolesServiceImpl implements RolesService {
    private RolesDao roleDao;

    @Override
    public List<Roles> findAll() throws ServiceException {
        try {
            return roleDao.readAll();
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }
    
    @Override
    public Roles findById(Long id) throws ServiceException {
        try {
            return roleDao.read(id);
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(Roles role) throws ServiceException {
        try {
            if(role.getId() != null) {
                roleDao.update(role);
            } else {
                roleDao.create(role);
            }
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            roleDao.delete(id);
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void setRolesDao(RolesDao roleDao) throws ServiceException {
        this.roleDao = roleDao;
    }
}