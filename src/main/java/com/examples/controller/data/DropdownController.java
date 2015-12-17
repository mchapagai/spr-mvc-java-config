package com.examples.controller.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.examples.model.data.User;
import com.examples.service.data.UserService;

@Controller
public class DropdownController {

	private static final String USERS_DROPDOWN_VIEW = "data/users_dropdown_view";

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users/dropdown", method = RequestMethod.GET)
	public ModelAndView userDropDownPage(@ModelAttribute User user) {

		List<User> details = userService.getUsersList();

		List<String> userCity = new ArrayList<String>();
		for (User record : details) {
			userCity.add(record.getCity());
		}
		List<String> userZip = new ArrayList<String>();
		for (User record : details) {
			userZip.add(record.getZip());
		}
		List<String> userCountry = new ArrayList<String>();
		for (User record : details) {
			userCountry.add(record.getCountry());
		}
		List<String> userEmail = new ArrayList<String>();
		for (User record : details) {
			userEmail.add(record.getEmail());
		}

		@SuppressWarnings("rawtypes")
		Map<String, List> map = new LinkedHashMap<String, List>();
		map.put("userCity", userCity);
		map.put("userZip", userZip);
		map.put("userCountry", userCountry);
		map.put("userEmail", userEmail);

		return new ModelAndView(USERS_DROPDOWN_VIEW, "map", map);
	}

	@RequestMapping(value = "/users/dropdown", method = RequestMethod.POST)
	public String submitAccountForm(@ModelAttribute User user, Model model) {
		model.addAttribute("message",
				"Successfully saved information: " + user.toString());
		return USERS_DROPDOWN_VIEW;
	}

}

