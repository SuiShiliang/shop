package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class HomeController {
	
	// '/'表示项目运行时默认调用此函数
	@RequestMapping(method = RequestMethod.GET,value = "/")
	public String home() {
		return "index";
	}

}
