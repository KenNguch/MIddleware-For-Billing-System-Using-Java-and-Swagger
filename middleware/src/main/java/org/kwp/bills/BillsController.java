package org.kwp.bills;

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
public class BillsController {

	@Autowired
	BillsDAO billsDAO;

	@RequestMapping(method = RequestMethod.GET, value = "/fetchAllBills")
	public List<BillsBean> fetchAllBills() throws SQLException {

		return billsDAO.fetchAllBills();
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "/createBill")
	public List<BillsBean> createBill(@RequestBody BillsBean billsBean) throws SQLException {

		return billsDAO.createBill(billsBean.getBill_name());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updateBill")
	
	public List<BillsBean> updateBill(@RequestBody BillsBean billsBean) throws SQLException {

		return billsDAO.updateBill(billsBean.getBill_id(), billsBean.getBill_name());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deleteBill")
	public List<BillsBean> deleteBill(@RequestParam BigDecimal bill_id) throws SQLException {

		return billsDAO.deleteBill(bill_id);
	}

}
