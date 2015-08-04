package org.pioto.thermostat.rest;

import lombok.Data;

/**
 * Basic system information
 *
 * @author Mike Kelly (pioto@pioto.org)
 *
 */
@Data
public class Sys {

	/**
	 * Unique identifier for the device
	 */
	private String uuid;

	/**
	 * HTTP API version.
	 */
	private Integer api_version;

	/**
	 * Firmware version
	 */
	private String fw_version;

	/**
	 * Underlying WLAN firmware version (referred from WiFi-certification
	 * documentation)
	 */
	private String wlan_fw_version;

}
