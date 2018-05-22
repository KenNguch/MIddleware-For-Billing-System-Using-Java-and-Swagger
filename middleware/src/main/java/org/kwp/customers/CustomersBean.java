package org.kwp.customers;

import java.math.BigDecimal;

public class CustomersBean {

	private BigDecimal customer_id;
	private String customer_name;
	private BigDecimal customer_connection_number;
	private String customer_phone_number;
	private String customer_email_address;

	public String getCustomer_email_address() {
		return customer_email_address;
	}

	public void setCustomer_email_address(String customer_email_address) {
		this.customer_email_address = customer_email_address;
	}

	public BigDecimal getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(BigDecimal customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public BigDecimal getCustomer_connection_number() {
		return customer_connection_number;
	}

	public void setCustomer_connection_number(BigDecimal customer_connection_number) {
		this.customer_connection_number = customer_connection_number;
	}

	public String getCustomer_phone_number() {
		return customer_phone_number;
	}

	public void setCustomer_phone_number(String customer_phone_number) {
		this.customer_phone_number = customer_phone_number;
	}

}