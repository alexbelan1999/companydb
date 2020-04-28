package pckg;

public class Time {
private static final long serialVersionUID = 1L;
	
	private Double createtime;
	private Double inserttime;
	private Double select1time;
	private Double updatetime;
	private Double select2time;
	private Double droptime;
	private Double alltime;
	
	public Time() {
		this.createtime = 0.0;
		this.inserttime = 0.0;
		this.select1time = 0.0;
		this.updatetime = 0.0;
		this.select2time = 0.0;
		this.droptime = 0.0;
		this.alltime = 0.0;
	}
	
	public void setCreatetime(Double createtime) {
		this.createtime = createtime;
	}
	public Double getCreatetime() {
		return createtime;
	}
	public void setInserttime(Double inserttime) {
		this.inserttime = inserttime;
	}
	public Double getInserttime() {
		return inserttime;
	}
	public void setSelect1time(Double select1time) {
		this.select1time = select1time;
	}
	public Double getSelect1time() {
		return select1time;
	}
	public void setUpdatetime(Double updatetime) {
		this.updatetime = updatetime;
	}
	public Double getUpdatetime() {
		return updatetime;
	}
	public void setSelect2time(Double select2time) {
		this.select2time = select2time;
	}
	public Double getSelect2time() {
		return select2time;
	}
	public void setDroptime(Double droptime) {
		this.droptime = droptime;
	}
	public Double getDroptime() {
		return droptime;
	}
	public void setAlltime(Double alltime) {
		this.alltime = alltime;
	}
	public Double getAlltime() {
		return alltime;
	}
	
}
