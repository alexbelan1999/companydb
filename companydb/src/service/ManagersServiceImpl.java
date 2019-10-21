package service;

import java.util.List;

import dao.ManagersDao;
import company.Managers;

public class ManagersServiceImpl implements ManagersService {
    private ManagersDao managerDao;

    @Override
    public List<Managers> findAll() {
        return managerDao.readAll();
    }

    public void setManagersDao(ManagersDao managerDao) {
        this.managerDao = managerDao;
    }
}