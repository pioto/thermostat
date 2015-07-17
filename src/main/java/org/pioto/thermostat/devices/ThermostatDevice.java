package org.pioto.thermostat.devices;

import lombok.Data;

/**
 * Details about a particular thermostat device, loaded from configuration.
 * @author Mike Kelly (pioto@pioto.org)
 *
 */
@Data
public class ThermostatDevice {
	private final String baseUrl;
}
