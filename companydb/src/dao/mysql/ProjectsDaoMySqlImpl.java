package dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import dao.ProjectsDao;
import dao.DaoException;
import company.*;

public class ProjectsDaoMySqlImpl extends BaseDaoMySqlImpl implements ProjectsDao {
    @Override
    public Long create(Projects project) throws DaoException {
        String sql = "INSERT INTO `projects` (`customer_id`, `project_name`, `start_date`, `plan_end_date`, `end_date`, `manager_id`, `success`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            if(project != null) {
                statement.setLong(1, project.getCustomer().getId());
            } else {
                statement.setNull(1, Types.BIGINT);
            }
            
            statement.setString(2, project.getProject_name());
            statement.setString(3, project.getStart_date());
            statement.setString(4, project.getPlan_end_date());
            statement.setString(5, project.getEnd_date());
            
            if(project.getManager() != null) {
                statement.setLong(6, project.getManager().getId());
            } else {
                statement.setNull(6, Types.BIGINT);
            }
            
            statement.setInt(7, project.getSuccess());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);
            project.setId(id);
            return id;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public Projects read(Long id) throws DaoException {
        String sql = "SELECT `customer_id`, `project_name`, `start_date`, `plan_end_date`, `end_date`, `manager_id`, `success` FROM `projects` WHERE `id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            Projects project = null;
            if(resultSet.next()) {
                project = new Projects();
                project.setId(id);
                
                Long customer_id = resultSet.getLong("customer_id");
                if(!resultSet.wasNull()) {
                    project.setCustomer(new Customers());
                    project.getCustomer().setId(customer_id);
                }
                
                project.setProject_name(resultSet.getString("project_name"));
                project.setStart_date(resultSet.getString("start_date"));
                project.setPlan_end_date(resultSet.getString("plan_end_date"));
                project.setEnd_date(resultSet.getString("end_date"));
                
                Long manager_id = resultSet.getLong("manager_id");
                if(!resultSet.wasNull()) {
                    project.setManager(new Managers());
                    project.getManager().setId(manager_id);
                }
                
                project.setSuccess(resultSet.getInt("success"));
            }
            return project;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public List<Projects> readByCustomer(Long customer_id) throws DaoException {
        String sql = null;
        if(customer_id != null) {
            sql = "SELECT `customer_id`, `project_name`, `start_date`, `plan_end_date`, `end_date`, `manager_id`, `success` FROM `projects` WHERE `customer_id` = ?";
        } else {
            sql = "SELECT `customer_id`, `project_name`, `start_date`, `plan_end_date`, `end_date`, `manager_id`, `success` FROM `projects` WHERE `customer_id` IS NULL";
        }
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql);
            Customers customer = null;
            if(customer_id != null) {
                statement.setLong(1, customer_id);
                customer = new Customers();
                customer.setId(customer_id);
            }
            resultSet = statement.executeQuery();
            List<Projects> projects = new ArrayList<>();
            while(resultSet.next()) {
                Projects project = new Projects();
                project.setId(resultSet.getLong("id"));
                project.setCustomer(customer);
                project.setProject_name(resultSet.getString("project_name"));
                project.setStart_date(resultSet.getString("start_date"));
                project.setPlan_end_date(resultSet.getString("plan_end_date"));
                project.setEnd_date(resultSet.getString("end_date"));
                
                Long manager_id = resultSet.getLong("manager_id");
                if(!resultSet.wasNull()) {
                    project.setManager(new Managers());
                    project.getManager().setId(manager_id);
                }
                
                project.setSuccess(resultSet.getInt("success"));
                projects.add(project);
            }
            return projects;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public List<Projects> readByManager(Long manager_id) throws DaoException {
        String sql = null;
        if(manager_id != null) {
            sql = "SELECT `customer_id`, `project_name`, `start_date`, `plan_end_date`, `end_date`, `manager_id`, `success` FROM `projects` WHERE `manager_id` = ?";
        } else {
            sql = "SELECT `customer_id`, `project_name`, `start_date`, `plan_end_date`, `end_date`, `manager_id`, `success` FROM `projects` WHERE `manager_id` IS NULL";
        }
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql);
            Managers manager = null;
            if(manager_id != null) {
                statement.setLong(1, manager_id);
                manager = new Managers();
                manager.setId(manager_id);
            }
            resultSet = statement.executeQuery();
            List<Projects> projects = new ArrayList<>();
            while(resultSet.next()) {
                Projects project = new Projects();
                project.setId(resultSet.getLong("id"));
                
                Long customer_id = resultSet.getLong("customer_id");
                if(!resultSet.wasNull()) {
                    project.setCustomer(new Customers());
                    project.getCustomer().setId(customer_id);
                }
                project.setProject_name(resultSet.getString("project_name"));
                project.setStart_date(resultSet.getString("start_date"));
                project.setPlan_end_date(resultSet.getString("plan_end_date"));
                project.setEnd_date(resultSet.getString("end_date")); 
                project.setManager(manager);
                project.setSuccess(resultSet.getInt("success"));
                projects.add(project);
            }
            return projects;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }
    
    @Override
    public List<Projects> readAll() throws DaoException {
        String sql = "SELECT `id`,`customer_id`, `project_name`, `start_date`, `plan_end_date`, `end_date`, `manager_id`, `success` FROM `projects`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<Projects> projects = new ArrayList<>();
            while(resultSet.next()) {
                Projects project = new Projects();
                project.setId(resultSet.getLong("id"));
                
                Long customer_id = resultSet.getLong("customer_id");
                if(!resultSet.wasNull()) {
                    project.setCustomer(new Customers());
                    project.getCustomer().setId(customer_id);
                }
                
                project.setProject_name(resultSet.getString("project_name"));
                project.setStart_date(resultSet.getString("start_date"));
                project.setPlan_end_date(resultSet.getString("plan_end_date"));
                project.setEnd_date(resultSet.getString("end_date"));
                
                Long manager_id = resultSet.getLong("manager_id");
                if(!resultSet.wasNull()) {
                    project.setManager(new Managers());
                    project.getManager().setId(manager_id);
                }
                
                project.setSuccess(resultSet.getInt("success"));
                projects.add(project);
            }
            return projects;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }
    
    @Override
    public void update(Projects project) throws DaoException {
        String sql = "UPDATE `projects` SET `customer_id` = ?, `project_name` = ?, `start_date` = ?, `plan_end_date` = ?, `end_date` = ?, `manager_id` = ?, `success` = ? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            
            if(project.getCustomer() != null) {
                statement.setLong(1,project.getCustomer().getId());
            } else {
                statement.setNull(1, Types.BIGINT);
            }
            
            statement.setString(2, project.getProject_name());
            statement.setString(3, project.getStart_date());
            statement.setString(4, project.getPlan_end_date());
            statement.setString(5, project.getEnd_date());
            
            if(project.getManager() != null) {
                statement.setLong(6, project.getManager().getId());
            } else {
                statement.setNull(6, Types.BIGINT);
            }
            statement.setInt(7, project.getSuccess());
            statement.setLong(8, project.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        String sql = "DELETE FROM `projects` WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { statement.close(); } catch(Exception e) {}
        }
    }
}
