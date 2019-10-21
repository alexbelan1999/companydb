package ioc;

import java.util.HashMap;
import java.util.Map;

public class IoCConfigurer {
    public static void configure() throws IoCException {
        IoCContainer.registerClass("dao.CustomersDao", "dao.fake.CustomersDaoFakeImpl");
        IoCContainer.registerClass("dao.ManagersDao", "dao.fake.ManagersDaoFakeImpl");
        IoCContainer.registerClass("dao.ProjectsDao", "dao.fake.ProjectsDaoFakeImpl");
        
        Map<String, String> customerServiceDependencies = new HashMap<>();
        customerServiceDependencies.put("dao.CustomersDao", "setCustomersDao");
        IoCContainer.registerClass("service.CustomersService", "service.CustomersServiceImpl", customerServiceDependencies);
           
        Map<String, String> managerServiceDependencies = new HashMap<>();
        managerServiceDependencies.put("dao.ManagersDao", "setManagersDao");
        IoCContainer.registerClass("service.ManagersService", "service.ManagersServiceImpl", managerServiceDependencies);
        
        Map<String, String> projectServiceDependencies = new HashMap<>();
        projectServiceDependencies.put("dao.CustomersDao", "setCustomersDao");
        projectServiceDependencies.put("dao.ManagersDao", "setManagersDao");
        projectServiceDependencies.put("dao.ProjectsDao", "setProjectsDao");
        IoCContainer.registerClass("service.ProjectsService", "service.ProjectsServiceImpl", projectServiceDependencies);
        
    }
}
