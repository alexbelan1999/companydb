package service;

import java.util.List;

import company.Users;

public interface UsersService {
    List<Users> findByRole(Long role_id) throws ServiceException;
    List<Users> findAll() throws ServiceException;
    Users findById(Long id) throws ServiceException;
    void save(Users project) throws ServiceException;
    void delete(Long id) throws ServiceException;
}