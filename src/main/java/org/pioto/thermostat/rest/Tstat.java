package org.pioto.thermostat.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Tstat {
	private Float temp;
}
