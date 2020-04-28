package by.vsu.company;
import java.sql.Date;
import by.vsu.project.Projects;
public class Company 
{
	private Integer id;
	private String cname;
	private String address;
	
	
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
		

	public int getCountProject() {
		return Projects.getProjectForCompany(this.id).size();
		
	}
	
	public int getCountEndProject() {
		return Projects.getEndProjectForCompany(this.id).size();
		
	}
}

