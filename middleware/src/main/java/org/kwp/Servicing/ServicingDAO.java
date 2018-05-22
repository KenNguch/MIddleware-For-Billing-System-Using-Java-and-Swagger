package org.kwp.Servicing;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository
public class ServicingDAO {

	@Autowired
	DataSource dataSource;

	public List<ServicingBean> fetchAllServicings() throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "SELECT 	servicing_id,servicing_service_id,servicing_employee_id,servicing_date,servicing_status from servicing";
		List<ServicingBean> servicingList = new ArrayList<ServicingBean>();

		try {

			conn = dataSource.getConnection();
			cst = conn.prepareStatement(selectSQL);

			ResultSet rs = cst.executeQuery();
			while (rs.next()) {

				ServicingBean servicing = new ServicingBean();
				servicing.setServicing_id(rs.getBigDecimal("servicing_id"));
				servicing.setServicing_service_id(rs.getBigDecimal("servicing_service_id"));
				servicing.setServicing_employee_id(rs.getBigDecimal("servicing_employee_id"));
				servicing.setServicing_date(rs.getDate("servicing_date"));
				servicing.setServicing_status(rs.getString("servicing_status"));

				servicingList.add(servicing);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return servicingList;
	}

	
	public List<ServicingBean> createServicing(BigDecimal servicing_id, BigDecimal servicing_service_id,
			BigDecimal servicing_employee_id, Date servicing_date, String servicing_status) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "INSERT INTO servicing(servicing_id,servicing_service_id,servicing_employee_id,servicing_date,servicing_status) values  ("
				+ genRandomInt() + "," + servicing_service_id + "," + servicing_employee_id + ",'" + currentdate()
				+ "','" + servicing_status + "')";

		List<ServicingBean> servicingList = new ArrayList<ServicingBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		servicingList = fetchAllServicings();

		return servicingList;
	}

	public List<ServicingBean> updateServicing(BigDecimal servicing_id, BigDecimal servicing_service_id,
			BigDecimal servicing_employee_id, Date servicing_date, String servicing_status) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "UPDATE servicing set servicing_service_id = " + servicing_service_id
				+ ",servicing_employee_id = " + servicing_employee_id + ",servicing_date = '" + currentdate()
				+ "',servicing_status ='" + servicing_status + "' where servicing_id=" + servicing_id + "";
		List<ServicingBean> servicingList = new ArrayList<ServicingBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		servicingList = fetchAllServicings();

		return servicingList;
	}

	public List<ServicingBean> deleteServicing(BigDecimal servicing_id) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "DELETE from servicing  where servicing_id =" + servicing_id + "";
		List<ServicingBean> servicingList = new ArrayList<ServicingBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		servicingList = fetchAllServicings();
		return servicingList;
	}
	public List<ServicingBean> fetchAllServicesForAnEmployee(BigDecimal employee_id) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "SELECT servicing_id,employee_id,employee_name,service_name,servicing_date,servicing_status from servicing,employees,services where servicing_service_id = service_id AND servicing_employee_id ="
				+ employee_id;
		List<ServicingBean> ServiceForAnEmployee = new ArrayList<ServicingBean>();

		try {

			conn = dataSource.getConnection();
			cst = conn.prepareStatement(selectSQL);

			ResultSet rs = cst.executeQuery();
			while (rs.next()) {
				ServicingBean employeeService = new ServicingBean();
				employeeService.setServicing_id(rs.getBigDecimal("servicing_id"));
				employeeService.setEmployee_id(rs.getBigDecimal("employee_id"));
				employeeService.setEmployee_name(rs.getString("employee_name"));
				employeeService.setService_name(rs.getString("service_name"));
				employeeService.setServicing_date(rs.getDate("servicing_date"));
				employeeService.setServicing_status(rs.getString("servicing_status"));

				ServiceForAnEmployee.add(employeeService);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return ServiceForAnEmployee;
	}

	public int genRandomInt() {

		Random rnd = new Random();
		return rnd.nextInt(30);

	}

	public Date currentdate() {
		Calendar calendar = Calendar.getInstance();

		java.util.Date currentDate = calendar.getTime();
		java.sql.Date date = new java.sql.Date(currentDate.getTime());

		return date;
	}

}
