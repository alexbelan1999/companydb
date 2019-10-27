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
        
        IoCContainer.registerFactory("java.sql.Connection", "pool.ConnectionFactory");
        
        Map<String, String> daoDependencies = map(pair("java.sql.Connection", "setConnection"));
        
        IoCContainer.registerClass("dao.CustomersDao", "dao.mysql.CustomersDaoMySqlImpl");
        DIContainer.registerClass("dao.mysql.CustomersDaoMySqlImpl", daoDependencies);
        
        IoCContainer.registerClass("dao.ManagersDao", "dao.mysql.ManagersDaoMySqlImpl");
        DIContainer.registerClass("dao.mysql.ManagersDaoMySqlImpl", daoDependencies);
        
        IoCContainer.registerClass("dao.ProjectsDao", "dao.mysql.ProjectsDaoMySqlImpl");
        DIContainer.registerClass("dao.mysql.ProjectsDaoMySqlImpl", daoDependencies);
        
        IoCContainer.registerClass("service.CustomersService", "service.CustomersServiceImpl");
        DIContainer.registerClass("service.CustomersServiceImpl", map(pair("dao.CustomersDao", "setCustomersDao")));
        
        IoCContainer.registerClass("service.ManagersService", "service.ManagersServiceImpl");
        DIContainer.registerClass("service.ManagersServiceImpl", map(pair("dao.ManagersDao", "setManagersDao")));
        
        IoCContainer.registerClass("service.ProjectsService", "service.ProjectsServiceImpl");
        DIContainer.registerClass("service.ProjectsServiceImpl", map(pair("dao.CustomersDao", "setCustomersDao"), pair("dao.ManagersDao", "setManagersDao"), pair("dao.ProjectsDao", "setProjectsDao")));
                
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
