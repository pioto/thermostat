package org.pioto.thermostat.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape=Shape.NUMBER)
public enum TTypePost {
	TEMPORARY_TARGET_TEMP,
	ABSOLUTE_TARGET_TEMP,
	UNKNOWN
}
