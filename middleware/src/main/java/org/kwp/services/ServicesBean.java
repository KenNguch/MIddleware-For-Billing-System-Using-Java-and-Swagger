package org.kwp.services;

import java.math.BigDecimal;

public class ServicesBean {

	private BigDecimal service_id;
	private String service_name;

	public BigDecimal getService_id() {
		return service_id;
	}

	public void setService_id(BigDecimal service_id) {
		this.service_id = service_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
}