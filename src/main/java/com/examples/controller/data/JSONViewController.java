package com.examples.controller.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.examples.model.data.User;
import com.examples.service.data.UserService;

@Controller
@RequestMapping(value = "users/json")
public class JSONViewController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	String getUsersJsonView(@ModelAttribute User users, ModelMap map)
			throws JSONException {
		JSONArray array = new JSONArray();

		for (User user : userService.getUsersList()) {
			JSONObject json = new JSONObject();

			json.put("id", user.getId());
			json.put("firstName", user.getFirstName());
			json.put("lastName", user.getLastName());
			json.put("city", user.getCity());
			json.put("zip", user.getZip());
			json.put("country", user.getCountry());
			json.put("email", user.getEmail());
			array.put(json);
		}
		return array.toString();
	}

}
