package org.pioto.thermostat.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape=Shape.NUMBER)
public enum Tstate {
	OFF,
	HEAT,
	COOL
}
