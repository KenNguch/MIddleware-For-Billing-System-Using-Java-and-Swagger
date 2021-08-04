package org.kwp.employees;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.kwp.SmsSender.SmsRestController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeesDAO {

    @Autowired
    DataSource dataSource;
    SmsRestController smsRestController;

    public List<EmployeesBean> fetchAllEmployees() throws SQLException {
        PreparedStatement cst = null;

        Connection conn = null;

        String selectSQL = "SELECT * from employees";
        List<EmployeesBean> employeesList = new ArrayList<EmployeesBean>();

        try {

            conn = dataSource.getConnection();

            cst = conn.prepareStatement(selectSQL);

            ResultSet rs = cst.executeQuery();
            while (rs.next()) {

                EmployeesBean employee = new EmployeesBean();
                employee.setEmployee_id(rs.getBigDecimal("employee_id"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setEmployee_phone_number(rs.getString("employee_phone_number"));
                employee.setEmployee_rank(rs.getString("employee_rank"));
                employee.setEmployee_email_address(rs.getString("employee_email_address"));
                employeesList.add(employee);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

        return employeesList;
    }

    public List<EmployeesBean> createEmployee(String employee_name, String employee_phone_number,
                                              String employee_rank, String employee_email_address) throws SQLException {
        PreparedStatement cst = null;

        Connection conn = null;

        String selectSQL = "INSERT INTO employees(employee_id,employee_name,employee_phone_number,employee_rank,employee_email_address) values  ("
                + genRandomInt() + ", '" + employee_name + "', '" + employee_phone_number + "','" + employee_rank + "','" + employee_email_address + "')";

        List<EmployeesBean> employeesList = new ArrayList<EmployeesBean>();

        try {

            conn = dataSource.getConnection();

            cst = conn.prepareStatement(selectSQL);

            cst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

        smsRestController.sendSms("Dear " + employee_name + " welcome to  Kamirithu Water Project employees,You are required to follow all the rules and regualations at all time.Please keep the email provided(+" + employee_email_address + " active to allow notification receival.", employee_phone_number);
        employeesList = fetchAllEmployees();
        return employeesList;
    }

    public List<EmployeesBean> updateEmployee(BigDecimal employee_id, String employee_name,
                                              String employee_phone_number, String employee_rank, String employee_email_address) throws SQLException {
        PreparedStatement cst = null;

        Connection conn = null;

        String selectSQL = "UPDATE employees set employee_name = '" + employee_name + "', employee_phone_number='" + employee_phone_number + "', employee_rank='" + employee_rank + "', employee_email_address='" + employee_email_address + "'where employee_id=" + employee_id
                + "";
        List<EmployeesBean> employeesList = new ArrayList<EmployeesBean>();

        try {

            conn = dataSource.getConnection();

            cst = conn.prepareStatement(selectSQL);

            cst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        employeesList = fetchAllEmployees();
        return employeesList;
    }

    public List<EmployeesBean> deleteEmployee(BigDecimal employee_id) throws SQLException {
        PreparedStatement cst = null;

        Connection conn = null;

        String selectSQL = "DELETE from employees  where employee_id = " + employee_id;
        List<EmployeesBean> employeesList = new ArrayList<EmployeesBean>();

        try {

            conn = dataSource.getConnection();

            cst = conn.prepareStatement(selectSQL);

            cst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        employeesList = fetchAllEmployees();
        return employeesList;
    }

    public int genRandomInt() {

        Random rnd = new Random();
        return rnd.nextInt(30);

    }

}
