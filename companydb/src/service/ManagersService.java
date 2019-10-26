package service;

import java.util.List;

import company.Managers;

public interface ManagersService {
    List<Managers> findAll() throws ServiceException;
    Managers findById(Long id) throws ServiceException;
    void save(Managers manager) throws ServiceException;
    void delete(Long id) throws ServiceException;
}