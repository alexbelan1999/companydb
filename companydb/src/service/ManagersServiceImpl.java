package service;

import java.util.List;

import dao.ManagersDao;
import dao.DaoException;
import company.Managers;

public class ManagersServiceImpl implements ManagersService {
    private ManagersDao managerDao;

    @Override
    public List<Managers> findAll() throws ServiceException{
        try {
            return managerDao.readAll();
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }
    
    @Override
    public Managers findById(Long id) throws ServiceException {
        try {
            return managerDao.read(id);
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(Managers manager) throws ServiceException {
        try {
            if(manager.getId() != null) {
                managerDao.update(manager);
            } else {
                managerDao.create(manager);
            }
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            managerDao.delete(id);
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }
    
    public void setManagersDao(ManagersDao managerDao) {
        this.managerDao = managerDao;
    }
}