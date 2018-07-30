package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.pojo.Commodity;
import shop.service.CommodityService;

@Controller
public class CommodityManageController {
	@Autowired
	private CommodityService commodityService;
	@RequestMapping(method = RequestMethod.GET,value = "/commodity/addCommodity")
	public String addCommodity(@ModelAttribute Commodity commodity) {
		return "edit-commodity";
	}
	@RequestMapping(method = RequestMethod.POST,value = "/commodity/addCommodity")
	public String createCommodity(@ModelAttribute Commodity commodity) {
		
		commodityService.addCommodity(commodity);
		return "redirect:/commodity/manageCommodity";
	}
	@RequestMapping(method = RequestMethod.GET,value = "/commodity/{id}/updateCommodity")
	public String editCommodity(@PathVariable Long id,Model model) {
		Commodity commodityi = new Commodity();
		commodityi.setId(id);
		List<Commodity> commodity = commodityService.findCommodityBy(commodityi);
		model.addAttribute("commodity",commodity.get(0));
		return "edit-commodity";
	}
	@RequestMapping(method = RequestMethod.POST,value = "/commodity/{id}/updateCommodity")
	public String updateCommodity(@ModelAttribute Commodity commodity,@PathVariable Long id,Model model) {
		commodityService.updateCommodity(commodity);
		return "redirect:/commodity/manageCommodity";
	}
	@RequestMapping(method = RequestMethod.GET,value = "/commodity/{id}/deleteCommodity")
	public String deleteCommodity(@PathVariable Long id) {
		commodityService.deleteCommodity(id);
		return "redirect:/commodity/manageCommodity";
	}
	@RequestMapping(method = RequestMethod.GET,value = "/commodity/manageCommodity")
	public String findAllCommodity(Model model) {
		Commodity commodity = new Commodity();
		List<Commodity> commodityList = commodityService.findCommodityBy(commodity );
		model.addAttribute("commodityList",commodityList);
		return "commodity-list";
	}
	@RequestMapping(method = RequestMethod.GET,value = "/commodity/search")
	public String searchCommodity(@ModelAttribute Commodity commodity,Model model) {
		List<Commodity> commodityList = commodityService.findCommodityBy(commodity );
		model.addAttribute("commodityList",commodityList);
		return "commodity-list";
	}
	
}
