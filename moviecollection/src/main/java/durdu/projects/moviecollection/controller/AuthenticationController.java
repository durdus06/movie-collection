package durdu.projects.moviecollection.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import durdu.projects.moviecollection.model.User;
import durdu.projects.moviecollection.service.impl.UserDetailsServiceImpl;

@Controller
public class AuthenticationController {
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	

	@GetMapping("/login")
	public String getLogin(@ModelAttribute("user")User user) {
		return "login";
	}
	
	
	@GetMapping("/register")
	public String getRegister(@ModelAttribute("user")User user) {
		return "register";
	}
	
	@PostMapping("/register")
	public String handleRegistiration(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, HttpServletRequest request) throws ServletException {
		
		if(bindingResult.hasErrors()) {
			return "register";
		}
		String password=user.getPassword();
		userDetailsServiceImpl.addUser(user);
		request.login(user.getEmail(), password);
		return "redirect:/";
	}
	
}
