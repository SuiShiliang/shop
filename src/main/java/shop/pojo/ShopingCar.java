package shop.pojo;


public class ShopingCar {
	private Long userId; 
	private Commodity commoditie;
	private Long count;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Commodity getCommoditie() {
		return commoditie;
	}
	public void setCommoditie(Commodity commoditie) {
		this.commoditie = commoditie;
	}
	

}
