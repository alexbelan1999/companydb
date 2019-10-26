package ioc;

import java.util.HashMap;
import java.util.Map;
import web.ActionFactory;

public class IoCConfigurer {
    public static void configure() throws IoCException {
        IoCContainer.registerFactory("web.Action", "web.ActionFactory");
        
        Map<String, String> customerActionsDependencies = map(pair("service.CustomersService", "setCustomersService"));
        ActionFactory.registerAction("/customer/list", "web.customer.CustomersListActionImpl");
        DIContainer.registerClass("web.customer.CustomersListActionImpl", customerActionsDependencies);
        ActionFactory.registerAction("/customer/edit", "web.customer.CustomersEditActionImpl");
        DIContainer.registerClass("web.customer.CustomersEditActionImpl", customerActionsDependencies);
        ActionFactory.registerAction("/customer/save", "web.customer.CustomersSaveActionImpl");
        DIContainer.registerClass("web.customer.CustomersSaveActionImpl", customerActionsDependencies);
        ActionFactory.registerAction("/customer/delete", "web.customer.CustomersDeleteActionImpl");
        DIContainer.registerClass("web.customer.CustomersDeleteActionImpl", customerActionsDependencies);
        
        Map<String, String> managerActionsDependencies = map(pair("service.ManagersService", "setManagersService"));
        ActionFactory.registerAction("/manager/list", "web.manager.ManagersListActionImpl");
        DIContainer.registerClass("web.manager.ManagersListActionImpl", managerActionsDependencies);
        ActionFactory.registerAction("/manager/edit", "web.manager.ManagersEditActionImpl");
        DIContainer.registerClass("web.manager.ManagersEditActionImpl", managerActionsDependencies);
        ActionFactory.registerAction("/manager/save", "web.manager.ManagersSaveActionImpl");
        DIContainer.registerClass("web.manager.ManagersSaveActionImpl", managerActionsDependencies);
        ActionFactory.registerAction("/manager/delete", "web.manager.ManagersDeleteActionImpl");
        DIContainer.registerClass("web.manager.ManagersDeleteActionImpl", managerActionsDependencies);
        
        Map<String, String> projectActionsDependencies = map(pair("service.ProjectsService", "setProjectsService"));
        ActionFactory.registerAction("/project/list", "web.project.ProjectsListActionImpl");
        DIContainer.registerClass("web.project.ProjectsListActionImpl", projectActionsDependencies);
        ActionFactory.registerAction("/project/edit", "web.project.ProjectsEditActionImpl");
        DIContainer.registerClass("web.project.ProjectsEditActionImpl", projectActionsDependencies);
        ActionFactory.registerAction("/project/save", "web.project.ProjectsSaveActionImpl");
        DIContainer.registerClass("web.project.ProjectsSaveActionImpl", projectActionsDependencies);
        ActionFactory.registerAction("/project/delete", "web.project.ProjectsDeleteActionImpl");
        DIContainer.registerClass("web.project.ProjectsDeleteActionImpl", projectActionsDependencies);
        
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
