package shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.pojo.Commodity;
import shop.pojo.ShopingCar;

public interface CommodityMapper {

	public void addCommodity(Commodity commodity);
	
	public void updateCommodity(Commodity commodity);
	
	public void deleteCommodity(Long id);
	//删除商品时，也将用户将其添加到购物车中的记录清除
	public void deleteShoppingCartOfCommodity(Long commodityId);
	//多条件查询，其中名字模糊查询
	public List<Commodity> findCommodityBy(Commodity commodity);
	//以下为购物车
	public void addOrder(ShopingCar car);
	
	public void updateOrder(ShopingCar car);
	
	public List<ShopingCar> findOrder(Long userId);
	
	public void deleteOrder(@Param("userId")Long userId,@Param("commodityId")Long commodityId);
	
	public long judgementOrder(@Param("userId")Long userId,@Param("commodityId")Long commodityId);
}
