package org.kwp.services;



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

@Repository
public class ServicesDAO {

	@Autowired
	DataSource dataSource;

	public List<ServicesBean> fetchAllServices() throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "SELECT service_id, service_name from services";
		List<ServicesBean> servicesList = new ArrayList<ServicesBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			ResultSet rs = cst.executeQuery();
			while (rs.next()) {

				ServicesBean services = new ServicesBean();
				services.setService_id(rs.getBigDecimal("service_id"));
				services.setService_name(rs.getString("service_name"));

				servicesList.add(services);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return servicesList;
	}

	public List<ServicesBean> createService(String service_name) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "INSERT INTO services(service_id,service_name) values  (" + genRandomInt() + ", '"
				+ service_name + "')";

	
		
		List<ServicesBean> servicesList = new ArrayList<ServicesBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		servicesList = fetchAllServices();
		return servicesList;
	}

	public List<ServicesBean> updateService(BigDecimal service_id, String service_name) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "UPDATE services set service_name = '" + service_name + "'  where service_id=" + service_id + "";
		List<ServicesBean> servicesList = new ArrayList<ServicesBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		servicesList = fetchAllServices();
		return servicesList;
	}

	public List<ServicesBean> deleteServices(BigDecimal service_id) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "DELETE from services where service_id = " + service_id;
		List<ServicesBean> servicesList = new ArrayList<ServicesBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		servicesList = fetchAllServices();
		return servicesList;
	}

	public int genRandomInt() {

		Random rnd = new Random();
		return rnd.nextInt(30);

	}

}
