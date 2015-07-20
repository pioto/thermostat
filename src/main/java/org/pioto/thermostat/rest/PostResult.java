package org.pioto.thermostat.rest;

import lombok.Data;

@Data
public class PostResult {

	/**
	 * If not {@code null}, the request was at least partially successful.
	 */
	private Integer success;

	/**
	 * If not {@code null}, the request failed.
	 */
	private Integer error;

	/**
	 * If not {@code null}, more detailed information about the error.
	 */
	private String error_msg;

}
