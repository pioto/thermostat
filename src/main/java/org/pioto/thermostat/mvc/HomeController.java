package org.pioto.thermostat.mvc;

import org.pioto.thermostat.devices.ThermostatDevice;
import org.pioto.thermostat.rest.Sys;
import org.pioto.thermostat.rest.Tstat;
import org.pioto.thermostat.services.ThermostatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ThermostatService thermostatService;

	@RequestMapping("/")
	public String home(Model model) {
		// TODO pull this from config or something...
		// perhaps use Marvell Service Discovery Protocol?
		ThermostatDevice dev = new ThermostatDevice("http://thermostat");

		Tstat tstat = thermostatService.getTstat(dev);
		logger.info("TSTAT: {}", tstat);

		Sys sys = thermostatService.getSys(dev);
		logger.info("SYS: {}", sys);

		model.addAttribute(tstat);
		model.addAttribute(sys);

		return "home";
	}
}
