package com.examples.controller.data;

import com.examples.model.data.User;
import com.examples.service.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "users")
public class UserCRUDController {

	private static final String USERS_LIST_VIEW = "data/users_list_view";
	private static final String USERS_REGISTRATION_PAGE = "data/users_registration_view";
	private static final String USERS_EDIT_PAGE = "data/users_edit_view";

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView renderUserList() {

		ModelAndView mav = new ModelAndView(USERS_LIST_VIEW);
		List<User> users = userService.getUsersList();
		mav.addObject("users", users);

		return mav;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView userRegistrationPage(@ModelAttribute User user) {
		return new ModelAndView(USERS_REGISTRATION_PAGE, "user", user);
	}

	@RequestMapping(value = "/save")
	public String insertNewUser(@ModelAttribute User user) {
		if (user != null) {
			userService.insertUserInfo(user);
		}
		return "redirect:/users";
	}

	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	public ModelAndView editUserInfo(@PathVariable("userId") Integer userId, ModelMap model) {
		ModelAndView mav = new ModelAndView(USERS_EDIT_PAGE);
        model.addAttribute("user", userService.getUserByUserId(userId));
		return mav;
    }


    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.POST)
    public String editContactPost(@PathVariable("userId") Integer userId,
                                  @Valid @ModelAttribute("user") User user, BindingResult result) {

        if (!result.hasErrors()) {
            user.setId(userId);
            userService.updateUser(user);
            return "redirect:/users";
        } else {
            return USERS_EDIT_PAGE;
        }
    }


	@RequestMapping(value = "/delete/{id}")
	public ModelAndView deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUserByUserId(id);
		return new ModelAndView("redirect:/users");
	}

}