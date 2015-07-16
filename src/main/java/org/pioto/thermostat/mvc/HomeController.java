package org.pioto.thermostat.mvc;

import org.pioto.thermostat.rest.Tstat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		model.addAttribute(restTemplate.getForObject("http://thermostat/tstat", Tstat.class));

		return "home";
	}
}
