package org.pioto.thermostat.jobs;

import org.pioto.thermostat.devices.ThermostatDevice;
import org.pioto.thermostat.rest.Tstat;
import org.pioto.thermostat.services.ThermostatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LoggerJobs {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ThermostatService thermostatService;

	@Scheduled(fixedRate=60*60*1000)
	public void logTstat() {
		// TODO pull this from config or something...
		ThermostatDevice dev = new ThermostatDevice("http://thermostat");

		Tstat tstat = thermostatService.getTstat(dev);
		logger.info("TSTAT: {}", tstat);
	}

}
