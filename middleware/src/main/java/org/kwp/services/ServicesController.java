package org.kwp.services;

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
@RequestMapping(value = "/kwp-modules/Service")
public class ServicesController {

    @Autowired
    ServicesDAO servicesDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/fetchAllServices")
    public List<ServicesBean> fetchAllServices() throws SQLException {

        return servicesDAO.fetchAllServices();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createService")
    public List<ServicesBean> createService(@RequestBody ServicesBean servicesBean) throws SQLException {

        return servicesDAO.createService(servicesBean.getService_name());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateService")
    public List<ServicesBean> updateService(@RequestBody ServicesBean servicesBean) throws SQLException {

        return servicesDAO.updateService(servicesBean.getService_id(), servicesBean.getService_name());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteService")
    public List<ServicesBean> deleteService(@RequestParam BigDecimal Service_id) throws SQLException {

        return servicesDAO.deleteServices(Service_id);
    }

}
