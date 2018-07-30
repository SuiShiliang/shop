package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.controller.form.ShoppingCartForm;
import shop.pojo.Commodity;
import shop.pojo.ShopingCar;
import shop.service.CommodityService;
@Controller
public class ShoopingCartController {
	@Autowired
	private CommodityService commodityService;
	
	/*//主页需加载商品数据，已在homecontroller代替
	@RequestMapping(method = RequestMethod.GET,value = "/commodity/getCommodity")
	public String showCommodity(Model model) {
		Commodity commodity = new Commodity();
		List<Commodity> commodityList = commodityService.findCommodityBy(commodity );
		model.addAttribute("commodityList",commodityList);
		return "redirect:/index";
	}*/
	@RequestMapping(method = RequestMethod.GET,value = "/commodity/{id}/getCommodityById")
	public String showCommodity(@PathVariable Long id, Model model) {
		Commodity commodity = new Commodity();
		commodity.setId(id);
		List<Commodity> commodityList = commodityService.findCommodityBy(commodity );
		ShoppingCartForm shoppingCartForm = new ShoppingCartForm();
		shoppingCartForm.setCommodity(commodityList.get(0));
		model.addAttribute("shoppingCartForm",shoppingCartForm);
		return "addToShoppingCart";
	}
	@RequestMapping(method = RequestMethod.POST,value = "/commodity/addToShoppingCart")
	public String addToShoppingCart(@ModelAttribute ShoppingCartForm shoppingCartForm,
			BindingResult bindingResult,
			@AuthenticationPrincipal(expression = "user.id") Long userId,
			Model model) {
		if(shoppingCartForm.getCount() == null || shoppingCartForm.getCount() <= 0) {
			bindingResult.rejectValue("count", "cn", "数量小于0");
			return "addToShoppingCart";
		}
		shoppingCartForm.setUserId(userId);
		if(commodityService.judgementOrder(userId, shoppingCartForm.getId())) {
			commodityService.updateOrder(shoppingCartForm.toShoppingCart());
		}
		else {
			commodityService.addOrder(shoppingCartForm.toShoppingCart());
		}
		return "redirect:/commodity/shoppingCart";
	}
	@RequestMapping(method = RequestMethod.GET,value = "/commodity/shoppingCart")
	public String shoppingCartList(@AuthenticationPrincipal(expression = "user.id") Long userId,Model model) {
		List<ShopingCar> shopingCarts = commodityService.findOrder(userId);
		model.addAttribute("shopingCarts",shopingCarts);
		return "shopping-cart";
	}
	@RequestMapping(method = RequestMethod.GET,value = "/commodity/{id}/deleteShopingItem")
	public String deleteShoppingItem(@PathVariable Long id,
			@AuthenticationPrincipal(expression = "user.id") Long userId) {
		commodityService.deleteOrder(userId, id);
		return "redirect:/commodity/shoppingCart";
	}
}
