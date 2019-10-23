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

    public void setManagersDao(ManagersDao managerDao) {
        this.managerDao = managerDao;
    }
}