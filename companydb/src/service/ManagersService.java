package service;

import java.util.List;

import company.Managers;

public interface ManagersService {
    List<Managers> findAll() throws ServiceException;
}