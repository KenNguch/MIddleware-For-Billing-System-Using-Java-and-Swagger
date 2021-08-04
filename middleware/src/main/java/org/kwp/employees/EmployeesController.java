package org.kwp.employees;

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
@RequestMapping(value = "/kwp-modules/Employees")
public class EmployeesController {

    @Autowired
    EmployeesDAO employeesDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/fetchAllEmployees")
    public List<EmployeesBean> fetchAllEmployees() throws SQLException {

        return employeesDAO.fetchAllEmployees();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createEmployee")
    public List<EmployeesBean> createEmployee(@RequestBody EmployeesBean employeesBean) throws SQLException {

        return employeesDAO.createEmployee(employeesBean.getEmployee_name(), employeesBean.getEmployee_phone_number(), employeesBean.getEmployee_rank(), employeesBean.getEmployee_email_address());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateEmployee")
    public List<EmployeesBean> updateEmployee(@RequestBody EmployeesBean employeesBean) throws SQLException {

        return employeesDAO.updateEmployee(employeesBean.getEmployee_id(), employeesBean.getEmployee_name(),
                employeesBean.getEmployee_phone_number(), employeesBean.getEmployee_rank(), employeesBean.getEmployee_email_address());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteEmployee")
    public List<EmployeesBean> deleteEmployee(@RequestParam BigDecimal Employee_id) throws SQLException {

        return employeesDAO.deleteEmployee(Employee_id);
    }

}
