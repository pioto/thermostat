package org.pioto.thermostat.services;

import org.pioto.thermostat.devices.ThermostatDevice;
import org.pioto.thermostat.rest.PostResult;
import org.pioto.thermostat.rest.Tstat;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThermostatServiceImpl implements ThermostatService {

	@Cacheable("tstat")
	@Override
	public Tstat getTstat(ThermostatDevice device) {
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.getForObject(device.getBaseUrl() + "/tstat",
				Tstat.class);
	}

	@Override
	public PostResult postTstat(ThermostatDevice device, Tstat tstat) {
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.postForObject(device.getBaseUrl() + "/tstat",
				tstat, PostResult.class);
	}

}
