package org.kwp.bills;

import java.math.BigDecimal;

public class BillsBean {

	private BigDecimal bill_id;
	private String bill_name;
	
	public BigDecimal getBill_id() {
		return bill_id;
	}
		public void setBill_id(BigDecimal bill_id) {
		this.bill_id = bill_id;
	}
	public String getBill_name() {
		return bill_name;
	}
	public void setBill_name(String bill_name) {
		this.bill_name = bill_name;
	}

}