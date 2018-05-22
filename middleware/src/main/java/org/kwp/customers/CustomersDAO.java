package org.kwp.customers;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.kwp.SmsSender.SmsRestController;

@Repository
public class CustomersDAO {

	@Autowired
	DataSource dataSource;
	SmsRestController smsRestController;

	public List<CustomersBean> fetchAllCustomers() throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "SELECT * from customers";
		List<CustomersBean> customersList = new ArrayList<CustomersBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			ResultSet rs = cst.executeQuery();
			while (rs.next()) {

				CustomersBean customers = new CustomersBean();
				customers.setCustomer_id(rs.getBigDecimal("customer_id"));
				customers.setCustomer_name(rs.getString("customer_name"));
				customers.setCustomer_phone_number(rs.getString("customer_phone_number"));
				customers.setCustomer_connection_number(rs.getBigDecimal("customer_connection_number"));
				customers.setCustomer_email_address(rs.getString("customer_email_address"));

				customersList.add(customers);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return customersList;
	}

	public List<CustomersBean> createCustomer(String customer_name, String customer_phone_number,
			BigDecimal customer_connection_number, String customer_email_address) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "INSERT INTO customers(customer_id,customer_name,customer_phone_number,customer_connection_number,customer_email_address) values  ("
				+ genRandomInt() + ", '" + customer_name + "','" + customer_phone_number + "',"
				+ customer_connection_number + ",'" + customer_email_address + "')";

		List<CustomersBean> customersList = new ArrayList<CustomersBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		smsRestController.sendSms("Dear " + customer_name + " welcome to  Kamirithu Water Project",
				customer_phone_number);
		customersList = fetchAllCustomers();
		return customersList;
	}

	public List<CustomersBean> updateCustomer(BigDecimal customer_id, String customer_name,
			String customer_phone_number, BigDecimal customer_connection_number, String customer_email_address)
			throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "UPDATE customers set customer_name = '" + customer_name + "', customer_connection_number = "
				+ customer_connection_number + ",customer_phone_number='" + customer_phone_number
				+ "',customer_email_address='" + customer_email_address + "' where customer_id=" + customer_id + "";
		List<CustomersBean> customersList = new ArrayList<CustomersBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		smsRestController.sendSms(
				"Dear " + customer_name + " your data in the   Kamirithu Water Project system has been updated",
				customer_phone_number);
		customersList = fetchAllCustomers();
		return customersList;
	}

	public List<CustomersBean> deleteCustomer(BigDecimal customer_id) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "DELETE from customers  where customer_id = " + customer_id;
		List<CustomersBean> customersList = new ArrayList<CustomersBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		customersList = fetchAllCustomers();
		return customersList;
	}

	public int genRandomInt() {

		Random rnd = new Random();
		return rnd.nextInt(30);

	}
	
	
	

}
