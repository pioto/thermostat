package org.pioto.thermostat.services;

import org.pioto.thermostat.devices.ThermostatDevice;
import org.pioto.thermostat.rest.PostResult;
import org.pioto.thermostat.rest.Sys;
import org.pioto.thermostat.rest.Tstat;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThermostatServiceImpl implements ThermostatService {

	private final RestTemplate restTemplate = new RestTemplate();

	@Cacheable("tstat")
	@Override
	public Tstat getTstat(ThermostatDevice device) {
		return restTemplate.getForObject(device.getBaseUrl() + "/tstat",
				Tstat.class);
	}

	@Override
	public PostResult postTstat(ThermostatDevice device, Tstat tstat) {
		return restTemplate.postForObject(device.getBaseUrl() + "/tstat",
				tstat, PostResult.class);
	}

	@Cacheable("sys")
	@Override
	public Sys getSys(ThermostatDevice device) {
		return restTemplate.getForObject(device.getBaseUrl() + "/sys",
				Sys.class);
	}

}
