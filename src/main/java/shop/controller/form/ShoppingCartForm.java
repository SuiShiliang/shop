package shop.controller.form;

import shop.pojo.Commodity;
import shop.pojo.ShopingCar;

public class ShoppingCartForm {
	private Long userId; 
	private Long count;
	//产品
	private Long id; 
	private String name; 
	private String brand; 
	private String model; 
	private String os; 
	private String cpu; 
	private int ram; 
	private int sc; 
	private String color; 
	private String discription; 
	private Double price;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getSc() {
		return sc;
	}
	public void setSc(int sc) {
		this.sc = sc;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public void setCommodity(Commodity commodity) {
		this.id = commodity.getId();
		this.name = commodity.getName();
		this.brand = commodity.getBrand();
		this.model = commodity.getModel();
		this.os = commodity.getOs();
		this.cpu = commodity.getCpu();
		this.ram = commodity.getRam();
		this.sc = commodity.getSc();
		this.color = commodity.getColor();
		this.discription = commodity.getDiscription();
		this.price = commodity.getPrice()/100;
	}
	
	public Commodity getCommodity() {
		Commodity commodity = new Commodity();
		commodity.setId(id);
		commodity.setName(name);
		commodity.setBrand(brand);
		commodity.setModel(model);
		commodity.setOs(os);
		commodity.setCpu(cpu);
		commodity.setRam(ram);
		commodity.setSc(sc);
		commodity.setColor(color);
		commodity.setDiscription(discription);
		commodity.setPrice(price);
		return commodity;
	}
	
	public ShopingCar toShoppingCart() {
		ShopingCar car = new ShopingCar();
		car.setUserId(userId);
		car.setCount(count);
		car.setCommoditie(this.getCommodity());
		return car;
	}

}
