package com.microservices.bean;

import org.springframework.stereotype.Component;

@Component
public class LimitsConfigurations {

	private String minimum;
	private String maximum;
	
	
	public LimitsConfigurations() {
	}
	
	
	public LimitsConfigurations(String minimum, String maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}


	public String getMinimum() {
		return minimum;
	}
	public void setMinimum(String minimum) {
		this.minimum = minimum;
	}
	public String getMaximum() {
		return maximum;
	}
	public void setMaximum(String maximum) {
		this.maximum = maximum;
	}
	
	
}
