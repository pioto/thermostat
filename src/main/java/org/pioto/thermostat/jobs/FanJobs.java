package org.pioto.thermostat.jobs;

import org.pioto.thermostat.devices.ThermostatDevice;
import org.pioto.thermostat.rest.Fmode;
import org.pioto.thermostat.rest.PostResult;
import org.pioto.thermostat.rest.Tstat;
import org.pioto.thermostat.services.ThermostatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Jobs to periodically do something clever with the fan settings on the thermostat.
 * @author Mike Kelly (pioto@pioto.org)
 *
 */
@Component
public class FanJobs {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ThermostatService thermostatService;

	@Scheduled(cron="0 0 20 * * *")
	public void autoFanOn() {
		logger.info("Turning fan from AUTO to ON");

		setFanState(Fmode.ON);
	}

	@Scheduled(cron="0 0 8 * * *")
	public void autoFanOff() {
		logger.info("Turning fan from ON to AUTO");

		setFanState(Fmode.AUTO);
	}

	private void setFanState(Fmode fmode) {
		Tstat tstat = new Tstat();
		tstat.setFmode(fmode);

		// TODO pull this from config or something...
		// perhaps use Marvell Service Discovery Protocol?
		ThermostatDevice dev = new ThermostatDevice("http://thermostat");
		PostResult result = thermostatService.postTstat(dev, tstat);
		logger.info("Changed fan state: {}", result);
	}
}
