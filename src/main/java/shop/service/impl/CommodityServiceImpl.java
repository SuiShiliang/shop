package shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mapper.CommodityMapper;
import shop.pojo.Commodity;
import shop.pojo.ShopingCar;
import shop.service.CommodityService;

@Service
public class CommodityServiceImpl implements CommodityService {
	@Autowired
	private CommodityMapper commodityMapper;

	@Override
	public void addCommodity(Commodity commodity) {
		commodityMapper.addCommodity(commodity);
	}

	@Override
	public void updateCommodity(Commodity commodity) {
		commodityMapper.updateCommodity(commodity);
	}

	@Override
	public void deleteCommodity(Long id) {

		commodityMapper.deleteCommodity(id);
	}

	@Override
	public List<Commodity> findCommodityBy(Commodity commodity) {
		return commodityMapper.findCommodityBy(commodity);
	}

	@Override
	public void addOrder(ShopingCar car) {
		commodityMapper.addOrder(car);
	}

	@Override
	public void updateOrder(ShopingCar car) {
		commodityMapper.updateOrder(car);
	}

	@Override
	public List<ShopingCar> findOrder(Long userId) {
		return commodityMapper.findOrder(userId);
	}

	@Override
	public void deleteOrder(Long userId, Long commodityId) {
		commodityMapper.deleteOrder(userId, commodityId);
	}

	@Override
	public boolean judgementOrder(Long userId, Long commodityId) {
		if (commodityMapper.judgementOrder(userId, commodityId) == 1)
			return true;
		return false;
	}

}
