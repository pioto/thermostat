package org.pioto.thermostat.services;

import org.pioto.thermostat.devices.ThermostatDevice;
import org.pioto.thermostat.rest.PostResult;
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

	/**
	 * Post the given tstat struct to the thermostat, initiating a change in state.
	 * @param tstat
	 * @return
	 */
	PostResult postTstat(ThermostatDevice device, Tstat tstat);

}
