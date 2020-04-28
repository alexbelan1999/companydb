package pckg;

public class Task {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String cipher;
	private String project_name;
	private String project_description;
	private Integer plan_time;
	private Integer actual_time;
	private Integer lag;
	
	public Task() {
		this.id = 0;
		this.cipher = "";
		this.project_name = "";
		this.project_description = "";
		this.plan_time = 0;
		this.actual_time = 0;
		this.lag = 0;
		
		
		
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setCipher(String str) {
		this.cipher = str;
	}
	
	public String getCipher() {
		return cipher;
	}
	
	public void setProject_name(String str) {
		this.project_name = str;
	}
	
	public String getProject_name() {
		return project_name;
	}
	
	public void setProject_description(String str) {
		this.project_description = str;
	}
	
	public String getProject_description() {
		return project_description;
	}
	
	public void setPlan_time(Integer time) {
		this.plan_time = time;
	}
	
	public Integer getPlan_time() {
		return plan_time;
	}
	
	public void setActual_time(Integer time) {
		this.actual_time = time;
	}
	
	public Integer getActual_time() {
		return actual_time;
	}
	
	public void setLag() {
		if (this.actual_time - this.plan_time > 0) {
			this.lag = this.actual_time - this.plan_time;
		}
		else {
			this.lag = 0;
		}
	}
	
	public Integer getLag() {
		return lag;
	}
	
	
	
}
