package com.examples.controller.jpa;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.examples.model.jpa.UserJPA;
import com.examples.service.jpa.UserJPAService;

@Controller
@RequestMapping(value = "jpa")
public class UserJPAController {

	private static final String USER_JPA_LIST = "jpa/user_jpa_list";
	private static final String USER_JPA_ADD = "jpa/user_jpa_add";
	private static final String USER_JPA_EDIT = "jpa/user_jpa_edit";

	@Autowired
	private UserJPAService userJPAService;

	@RequestMapping(method = RequestMethod.GET)
	public String listContacts(ModelMap model) {

		model.addAttribute("user", new UserJPA());
		model.addAttribute("userList", userJPAService.listUser());
		return USER_JPA_LIST;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addContactGet(ModelMap model) {

		model.addAttribute("user", new UserJPA());
		return USER_JPA_ADD;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContactPost(@Valid @ModelAttribute("user") UserJPA user,
			BindingResult result, ModelMap model) {

		if (!result.hasErrors()) {
			userJPAService.addUserInformation(user);
			model.addAttribute("message", "User was successfully added.");
			model.addAttribute("errorType", "info");
			return USER_JPA_ADD;
		} else {
			model.addAttribute("message", "Error adding a user.");
			model.addAttribute("errorType", "danger");
			return USER_JPA_ADD;
		}
	}

	@RequestMapping(value = "/edit/{contactId}", method = RequestMethod.GET)
	public String editContactGet(@PathVariable("contactId") Integer userId,
			ModelMap model) {

		model.addAttribute("contact", userJPAService.getUserByUserId(userId));
		return USER_JPA_EDIT;
	}

	@RequestMapping(value = "/edit/{contactId}", method = RequestMethod.POST)
	public String editContactPost(@PathVariable("contactId") Integer contactId,
			@Valid @ModelAttribute("contact") UserJPA contact, BindingResult result,
			ModelMap model) {

		if (!result.hasErrors()) {
			contact.setId(contactId);
			userJPAService.insertOrUpdateUser(contact);
			model.addAttribute("message", "User was successfully edited.");
			model.addAttribute("errorType", "info");
			return "redirect:/jpa";
		} else {
			model.addAttribute("message", "Error editing a user.");
			model.addAttribute("errorType", "danger");
			return USER_JPA_EDIT;
		}
	}

	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) {

		userJPAService.removeUserByUserId(contactId);
		return "redirect:/jpa";
	}

}
