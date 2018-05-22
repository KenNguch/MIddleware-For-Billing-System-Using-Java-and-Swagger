package org.kwp.Servicing;

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
@RequestMapping(value = "/kwp-modules/Servicing")
public class ServicingController {

	@Autowired
	ServicingDAO servicingDAO;

	@RequestMapping(method = RequestMethod.GET, value = "/fetchAllServices")
	public List<ServicingBean> fetchAllServicings() throws SQLException {

		return servicingDAO.fetchAllServicings();
	}
	@RequestMapping(method = RequestMethod.GET, value = "/fetchAllServicesForAnEmployee")
	public List<ServicingBean>fetchAllServicesForAnEmployee(@RequestBody BigDecimal employee_id) throws SQLException {

		return servicingDAO.fetchAllServicesForAnEmployee(employee_id);
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "/createServicing")
	public List<ServicingBean> createServicing(@RequestBody ServicingBean servicingBean) throws SQLException {

		return servicingDAO.createServicing(servicingBean.getServicing_id(),servicingBean.getServicing_service_id(),servicingBean.getServicing_employee_id(),servicingBean.getServicing_date(),servicingBean.getServicing_status());
		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updateServicing")
	
	public List<ServicingBean> updateServicing(@RequestBody ServicingBean servicingBean) throws SQLException {

		return servicingDAO.updateServicing(servicingBean.getServicing_id(),servicingBean.getServicing_service_id(),servicingBean.getServicing_employee_id(),servicingBean.getServicing_date(),servicingBean.getServicing_status());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deleteServicing")
	public List<ServicingBean> deleteServicing(@RequestParam BigDecimal servicing_id) throws SQLException {

		return servicingDAO.deleteServicing(servicing_id);
	}

}
