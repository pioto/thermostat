package org.pioto.thermostat.mvc;

import org.pioto.thermostat.rest.Tstat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("/")
	public String home(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		Tstat tstat = restTemplate.getForObject("http://thermostat/tstat", Tstat.class);
		logger.info("TSTAT: {}", tstat);

		model.addAttribute(tstat);

		return "home";
	}
}
