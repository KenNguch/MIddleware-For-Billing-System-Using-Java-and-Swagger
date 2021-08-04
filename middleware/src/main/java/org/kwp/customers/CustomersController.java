package org.kwp.customers;

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
@RequestMapping(value = "/kwp-modules/Customers")
public class CustomersController {

    @Autowired
    CustomersDAO customersDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/fetchAllCustomers")
    public List<CustomersBean> fetchAllCustomers() throws SQLException {

        return customersDAO.fetchAllCustomers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createCustomer")
    public List<CustomersBean> createCustomer(@RequestBody CustomersBean customersBean) throws SQLException {

        return customersDAO.createCustomer(customersBean.getCustomer_name(), customersBean.getCustomer_phone_number(), customersBean.getCustomer_connection_number(), customersBean.getCustomer_email_address());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateCustomer")
    public List<CustomersBean> updateCustomer(@RequestBody CustomersBean customersBean) throws SQLException {

        return customersDAO.updateCustomer(customersBean.getCustomer_id(), customersBean.getCustomer_name(), customersBean.getCustomer_phone_number(), customersBean.getCustomer_connection_number(), customersBean.getCustomer_email_address());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteCustomer")
    public List<CustomersBean> deleteCustomer(@RequestParam BigDecimal customer_id) throws SQLException {

        return customersDAO.deleteCustomer(customer_id);
    }


}
