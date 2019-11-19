package service;

import java.util.List;

import company.Roles;

public interface RolesService {
    List<Roles> findAll() throws ServiceException;
    Roles findById(Long id) throws ServiceException;
    void save(Roles role) throws ServiceException;
    void delete(Long id) throws ServiceException;
}