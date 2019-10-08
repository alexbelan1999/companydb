package company;

public class Customers extends Entity {
    private String name;
    private String address;
    private Integer total_pnumber;
    private Integer complet_pnumber;
        
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public Integer getTotal_pnumber() {
        return total_pnumber;
    }
    
    public void setTotal_pnumber(Integer number) {
        this.total_pnumber = number;
    }
    
    public Integer getComplet_pnumbe() {
        return complet_pnumber;
    }
    
    public void setComplet_pnumbe(Integer number) {
        this.complet_pnumber = number;
    }
}