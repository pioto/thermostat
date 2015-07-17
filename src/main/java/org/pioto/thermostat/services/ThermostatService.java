package org.pioto.thermostat.services;

import org.pioto.thermostat.devices.ThermostatDevice;
import org.pioto.thermostat.rest.Tstat;

/**
 * Service to interact with the thermostat.
 * @author Mike Kelly (pioto@pioto.org)
 *
 */
public interface ThermostatService {

	/**
	 * Get the current Thermostat state.
	 * @param device the device to get details for
	 * @return
	 */
	Tstat getTstat(ThermostatDevice device);

}
