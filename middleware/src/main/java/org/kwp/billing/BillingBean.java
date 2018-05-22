	package org.kwp.billing;

	import java.math.BigDecimal;
	import java.sql.Date;

	public class BillingBean {


		private BigDecimal billing_id;
		private BigDecimal billing_bill_id;
		private BigDecimal billing_customer_connection_number;
		private Date billing_date;
		private String customer_name,bill_name;


		public BigDecimal getBilling_id() {
			return billing_id;
		}
		public void setBilling_id(BigDecimal billing_id) {
			this.billing_id = billing_id;
		}
		public BigDecimal getBilling_bill_id() {
			return billing_bill_id;
		}
		public void setBilling_bill_id(BigDecimal billing_bill_id) {
			this.billing_bill_id = billing_bill_id;
		}

		public Date getBilling_date() {
			return billing_date;
		}
		public void setBilling_date(Date billing_date) {
			this.billing_date = billing_date;
		}
		public BigDecimal getBilling_customer_connection_number() {
			return billing_customer_connection_number;
		}
		public void setBilling_customer_connection_number(BigDecimal billing_customer_connection_number) {
			this.billing_customer_connection_number = billing_customer_connection_number;
		}
		public String getCustomer_name() {
			return customer_name;
		}
		public void setCustomer_name(String customer_name) {
			this.customer_name = customer_name;
		}
		public String getBill_name() {
			return bill_name;
		}
		public void setBill_name(String bill_name) {
			this.bill_name = bill_name;
		}
	}