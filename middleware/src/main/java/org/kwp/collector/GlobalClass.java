package org.kwp.collector;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;


public class GlobalClass {

	@Autowired
	DataSource dataSource;

	public String getCustomerEmail(BigDecimal customer_id) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "SELECT customer_email_address from customers where 	customer_id= " + customer_id;
		String email = null;

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			ResultSet rs = cst.executeQuery();
			while (rs.next()) {

				email = rs.getString("customer_email_address");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return email;
	}
	
	
	public String getCustomerSms(BigDecimal customer_id) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "SELECT 	customer_phone_number from customers where customer_id= " + customer_id;
		String phone_number = null;

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			ResultSet rs = cst.executeQuery();
			while (rs.next()) {

				phone_number = rs.getString("customer_sms");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return phone_number;
	}

}
