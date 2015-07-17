package org.pioto.thermostat.services;

import java.util.Collection;

import org.pioto.thermostat.devices.ThermostatDevice;

public interface DiscoveryService {

	/**
	 * Attempts to discover all known devices.
	 * @return
	 */
	// TODO return a Future here, maybe?
	// TODO definitely use caching here
	Collection<ThermostatDevice> discoverDevices();

}
