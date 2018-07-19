package shop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.controller.form.UsersForm;
import shop.service.UserManageService;

@Controller
public class RegisterController {
	@Autowired
	private UserManageService manageService;

	@RequestMapping(method = RequestMethod.GET,value = "/regUser")
	public String regUser(@ModelAttribute @Valid UsersForm usersForm) {
			return "/register";
	}
	@RequestMapping(method = RequestMethod.POST,value = "/regUser")
	public String createUser(@ModelAttribute @Valid UsersForm usersForm,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/register";
		}
		manageService.registerUser(usersForm.toUsers());
		return "redirect:/login";
	}
}
