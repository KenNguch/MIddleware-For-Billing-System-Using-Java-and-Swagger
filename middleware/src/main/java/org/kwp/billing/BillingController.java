package org.kwp.billing;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kwp-modules/Bills")
public class BillingController {

	@Autowired
	BillingDAO billingDAO;

	@RequestMapping(method = RequestMethod.GET, value = "/fetchAllBillings")
	public List<BillingBean> fetchAllBills() throws SQLException {

		return billingDAO.fetchAllBillings();
	}
	@RequestMapping(method = RequestMethod.GET, value = "/fetchAllBillingsAForCustomer")
	public List<BillingBean> fetchAllBillingsAForCustomer(@RequestParam BigDecimal customer_connection_number) throws SQLException {

		return billingDAO.fetchAllBillingsForACustomer(customer_connection_number);
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "/createBilling")
	public List<BillingBean> createBilling(@RequestBody BillingBean billingBean) throws SQLException {

		return billingDAO.createBilling(billingBean.getBilling_id(),billingBean.getBilling_bill_id(),billingBean.getBilling_customer_connection_number(),billingBean.getBilling_date());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updateBilling")
	
	public List<BillingBean> updateBilling(@RequestBody BillingBean billingBean) throws SQLException {

		return billingDAO.updateBilling(billingBean.getBilling_id(),billingBean.getBilling_bill_id(), billingBean.getBilling_customer_connection_number(),billingBean.getBilling_date());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deleteBilling")
	public List<BillingBean> deleteBilling(@RequestParam BigDecimal bill_id) throws SQLException {

		return billingDAO.deleteBilling(bill_id);
	}

}
