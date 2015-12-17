package com.examples.controller.form;

import com.examples.model.form.Subscriber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SubscriberController {

    private static final String SUBSCRIBER_FORM = "form/subscriber_form_page";


    @ModelAttribute("frequencies")
    public Subscriber.Frequency[] frequencies() {
        return Subscriber.Frequency.values();
    }

    @ModelAttribute("genders")
    public Subscriber.Gender[] genders() {
        return Subscriber.Gender.values();
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String subscriberFormPage(Model model) {
        model.addAttribute("subscriber", new Subscriber());
        return SUBSCRIBER_FORM;
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String submitForm(Subscriber subscriber, Model model) {
        model.addAttribute("message", "Successfully saved person: " + subscriber.toString());
        return SUBSCRIBER_FORM;
    }

}