package com.microservices.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class LimitsConf {
	
	private String minimum;
	private String maximum;
	

	public LimitsConf() {
		super();
	}

	public LimitsConf(String minimum, String maximum) {
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



	@Override
	public String toString() {
		return "LimitsConf [minimum=" + minimum + ", maximum=" + maximum + "]";
	}
	
	
	
	

}
