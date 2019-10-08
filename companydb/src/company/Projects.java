package company;

public class Projects extends Entity {
    private String project_name;
    private String start_date;
    private String plan_end_date;
    private String end_date;
    private Integer customer_id;
    private Integer manager_id;
    private Integer success;
    
    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
    
    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String date) {
        this.start_date = date;
    }
    
    public String getPlan_end_date() {
        return plan_end_date;
    }

    public void setPlan_end_date(String date) {
        this.plan_end_date = date;
    }
    
    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String date) {
        this.end_date = date;
    }
    
    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer id) {
        this.customer_id = id;
    }
    
    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer id) {
        this.manager_id = id;
    }
    
    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }
}
