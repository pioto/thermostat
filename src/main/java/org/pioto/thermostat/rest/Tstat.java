package org.pioto.thermostat.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Tstat {
	/**
	 * Current temperature
	 */
	private Float temp;
	/**
	 * Thermostat operating mode
	 */
	private Tmode tmode;
	/**
	 * Fan operating mode
	 */
	private Fmode fmode;
	/**
	 * Target temperature temporary override status
	 */
	private Boolean override;
	/**
	 * Target temperature Hold status
	 */
	private Boolean hold;
	/**
	 * Temporary Target Heat Setpoint: Sets target and MODE
	 */
	private Float t_heat;
	/**
	 * Temporary Target Cool Setpoint: Sets target and MODE
	 */
	private Float t_cool;
	/**
	 * Temporary Target Heat Setpoint
	 */
	private Float it_heat;
	/**
	 * Temporary Target Cool Setpoint
	 */
	private Float it_cool;
	/**
	 * Absolute Target Heat Setpoint
	 */
	private Float a_heat;
	/**
	 * Absolute Target Cool Setpoint
	 */
	private Float a_cool;
	/**
	 * Absolute Target Temperature Mode
	 */
	private Boolean a_mode;
	/**
	 * Target Temperature POST type
	 */
	private TTypePost t_type_post;
	/**
	 * HVAC Operating State
	 */
	private Tstate tstate;
	/**
	 * Fan Operating State
	 */
	private Fstate fstate;

}
