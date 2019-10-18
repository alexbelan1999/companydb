package dao;

import java.util.List;
import company.Managers;

public interface ManagersDao extends DAO<Managers> {
    List<Managers> readAll();
}