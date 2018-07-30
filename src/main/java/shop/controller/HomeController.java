package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.pojo.Commodity;
import shop.service.CommodityService;
@Controller
public class HomeController {
	@Autowired
	private CommodityService commodityService;
	// '/'表示项目运行时默认调用此函数,并加载商品
	@RequestMapping(method = RequestMethod.GET,value = "/")
	public String home(Model model) {
		Commodity commodity = new Commodity();
		List<Commodity> commodityList = commodityService.findCommodityBy(commodity );
		model.addAttribute("commodityList",commodityList);
		return "index";
	}

}
