package ioc;

import java.util.HashMap;
import java.util.Map;
import web.ActionFactory;

public class IoCConfigurer {
    public static void configure() throws IoCException {
        IoCContainer.registerFactory("web.Action", "web.ActionFactory");
        
        Map<String, String> customerActionsDependencies = map(pair("service.CustomersService", "setCustomersService"));
        ActionFactory.registerAction("/customer/list", "web.customers.CustomersListActionImpl");
        DIContainer.registerClass("web.customers.CustomersListActionImpl", customerActionsDependencies);
        ActionFactory.registerAction("/customer/edit", "web.customers.CustomersEditActionImpl");
        DIContainer.registerClass("web.customers.CustomersEditActionImpl", customerActionsDependencies);
        ActionFactory.registerAction("/customer/save", "web.customers.CustomersSaveActionImpl");
        DIContainer.registerClass("web.customers.CustomersSaveActionImpl", customerActionsDependencies);
        ActionFactory.registerAction("/customer/delete", "web.customers.CustomersDeleteActionImpl");
        DIContainer.registerClass("web.customers.CustomersDeleteActionImpl", customerActionsDependencies);
        
        Map<String, String> managerActionsDependencies = map(pair("service.ManagersService", "setManagersService"));
        ActionFactory.registerAction("/manager/list", "web.managers.ManagersListActionImpl");
        DIContainer.registerClass("web.managers.ManagersListActionImpl", managerActionsDependencies);
        ActionFactory.registerAction("/manager/edit", "web.managers.ManagersEditActionImpl");
        DIContainer.registerClass("web.managers.ManagersEditActionImpl", managerActionsDependencies);
        ActionFactory.registerAction("/manager/save", "web.managers.ManagersSaveActionImpl");
        DIContainer.registerClass("web.managers.ManagersSaveActionImpl", managerActionsDependencies);
        ActionFactory.registerAction("/manager/delete", "web.managers.ManagersDeleteActionImpl");
        DIContainer.registerClass("web.managers.ManagersDeleteActionImpl", managerActionsDependencies);
        
        Map<String, String> projectActionsDependencies = map(pair("service.ProjectsService", "setProjectsService"));
        ActionFactory.registerAction("/project/list", "web.projects.ProjectsListActionImpl");
        DIContainer.registerClass("web.projects.ProjectsListActionImpl", projectActionsDependencies);
        ActionFactory.registerAction("/project/edit", "web.projects.ProjectsEditActionImpl");
        DIContainer.registerClass("web.projects.ProjectsEditActionImpl", projectActionsDependencies);
        ActionFactory.registerAction("/project/save", "web.projects.ProjectsSaveActionImpl");
        DIContainer.registerClass("web.projects.ProjectsSaveActionImpl", projectActionsDependencies);
        ActionFactory.registerAction("/project/delete", "web.projects.ProjectsDeleteActionImpl");
        DIContainer.registerClass("web.projects.ProjectsDeleteActionImpl", projectActionsDependencies);
        
        Map<String, String> roleActionsDependencies = map(pair("service.RolesService", "setRolesService"));
        ActionFactory.registerAction("/role/list", "web.roles.RolesListActionImpl");
        DIContainer.registerClass("web.roles.RolesListActionImpl", roleActionsDependencies);
        ActionFactory.registerAction("/role/edit", "web.roles.RolesEditActionImpl");
        DIContainer.registerClass("web.roles.RolesEditActionImpl", roleActionsDependencies);
        ActionFactory.registerAction("/role/save", "web.roles.RolesSaveActionImpl");
        DIContainer.registerClass("web.roles.RolesSaveActionImpl", roleActionsDependencies);
        ActionFactory.registerAction("/role/delete", "web.roles.RolesDeleteActionImpl");
        DIContainer.registerClass("web.roles.RolesDeleteActionImpl", roleActionsDependencies);
        
        Map<String, String> userActionsDependencies = map(pair("service.UsersService", "setUsersService"));
        ActionFactory.registerAction("/user/list", "web.users.UsersListActionImpl");
        DIContainer.registerClass("web.users.UsersListActionImpl", userActionsDependencies);
        ActionFactory.registerAction("/user/edit", "web.users.UsersEditActionImpl");
        DIContainer.registerClass("web.users.UsersEditActionImpl", userActionsDependencies);
        ActionFactory.registerAction("/user/save", "web.users.UsersSaveActionImpl");
        DIContainer.registerClass("web.users.UsersSaveActionImpl", userActionsDependencies);
        ActionFactory.registerAction("/user/delete", "web.users.UsersDeleteActionImpl");
        DIContainer.registerClass("web.users.UsersDeleteActionImpl", userActionsDependencies);
        ActionFactory.registerAction("/user/login", "web.users.UsersLoginActionImpl");
        DIContainer.registerClass("web.users.UsersLoginActionImpl", userActionsDependencies);
        ActionFactory.registerAction("/user/logout", "web.users.UsersLogoutActionImpl");
        DIContainer.registerClass("web.users.UsersLogoutActionImpl", userActionsDependencies);
        
        IoCContainer.registerFactory("java.sql.Connection", "pool.ConnectionFactory");
        
        Map<String, String> daoDependencies = map(pair("java.sql.Connection", "setConnection"));
        
        IoCContainer.registerClass("dao.CustomersDao", "dao.mysql.CustomersDaoMySqlImpl");
        DIContainer.registerClass("dao.mysql.CustomersDaoMySqlImpl", daoDependencies);
        
        IoCContainer.registerClass("dao.ManagersDao", "dao.mysql.ManagersDaoMySqlImpl");
        DIContainer.registerClass("dao.mysql.ManagersDaoMySqlImpl", daoDependencies);
        
        IoCContainer.registerClass("dao.ProjectsDao", "dao.mysql.ProjectsDaoMySqlImpl");
        DIContainer.registerClass("dao.mysql.ProjectsDaoMySqlImpl", daoDependencies);
        
        IoCContainer.registerClass("dao.RolesDao", "dao.mysql.RolesDaoMySqlImpl");
        DIContainer.registerClass("dao.mysql.RolesDaoMySqlImpl", daoDependencies);
        
        IoCContainer.registerClass("dao.UsersDao", "dao.mysql.UsersDaoMySqlImpl");
        DIContainer.registerClass("dao.mysql.UsersDaoMySqlImpl", daoDependencies);
        
        IoCContainer.registerClass("service.CustomersService", "service.CustomersServiceImpl");
        DIContainer.registerClass("service.CustomersServiceImpl", map(pair("dao.CustomersDao", "setCustomersDao")));
        
        IoCContainer.registerClass("service.ManagersService", "service.ManagersServiceImpl");
        DIContainer.registerClass("service.ManagersServiceImpl", map(pair("dao.ManagersDao", "setManagersDao")));
        
        IoCContainer.registerClass("service.ProjectsService", "service.ProjectsServiceImpl");
        DIContainer.registerClass("service.ProjectsServiceImpl", map(pair("dao.CustomersDao", "setCustomersDao"), pair("dao.ManagersDao", "setManagersDao"), pair("dao.ProjectsDao", "setProjectsDao")));
                
        IoCContainer.registerClass("service.RolesService", "service.RolesServiceImpl");
        DIContainer.registerClass("service.RolesServiceImpl", map(pair("dao.RolesDao", "setRolesDao")));
        
        IoCContainer.registerClass("service.UsersService", "service.UsersServiceImpl");
        DIContainer.registerClass("service.UsersServiceImpl", map(pair("dao.RolesDao", "setRolesDao"), pair("dao.UsersDao", "setUsersDao")));
    }
    
    private static Map<String, String> map(String[] ... strings) {
        Map<String, String> result = new HashMap<>();
        for(String[] pair : strings) {
            result.put(pair[0], pair[1]);
        }
        return result;
    }

    private static String[] pair(String key, String value) {
        return new String[] {key, value};
    }
}
