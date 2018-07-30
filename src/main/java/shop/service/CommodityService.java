package shop.service;

import java.util.List;


import shop.pojo.Commodity;
import shop.pojo.ShopingCar;

public interface CommodityService {
	public void addCommodity(Commodity commodity);
	
	public void updateCommodity(Commodity commodity);
	
	public void deleteCommodity(Long id);
	//多条件查询，其中名字模糊查询
	public List<Commodity> findCommodityBy(Commodity commodity);
	//以下为购物车
	public void addOrder(ShopingCar car);
	
	public void updateOrder(ShopingCar car);
	
	public List<ShopingCar> findOrder(Long userId);
	
	public void deleteOrder(Long userId,Long commodityId);
	
	public boolean judgementOrder(Long userId,Long commodityId);
}
