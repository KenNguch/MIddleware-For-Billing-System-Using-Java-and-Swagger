package org.kwp.bills;

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
public class BillsDAO {

	@Autowired
	DataSource dataSource;

	public List<BillsBean> fetchAllBills() throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "SELECT bill_id, bill_name  from bills";
		List<BillsBean> billsList = new ArrayList<BillsBean>();

		try {

			conn = dataSource.getConnection();
			cst = conn.prepareStatement(selectSQL);

			ResultSet rs = cst.executeQuery();
			while (rs.next()) {

				BillsBean bills = new BillsBean();
				bills.setBill_id(rs.getBigDecimal("bill_id"));
				bills.setBill_name(rs.getString("bill_name"));
				
				
				billsList.add(bills);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return billsList;
	}

	public List<BillsBean> createBill(String bill_name) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "INSERT INTO bills(bill_id,bill_name) values  (" + genRandomInt() + ",'"+ bill_name + "')";

		List<BillsBean> billsList = new ArrayList<BillsBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		billsList = fetchAllBills();
		return billsList;
	}

	public List<BillsBean> updateBill(BigDecimal bill_id, String bill_name) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "UPDATE bills set bill_name = '" + bill_name +"'  where bill_id=" + bill_id + "";
		List<BillsBean> billsList = new ArrayList<BillsBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		billsList = fetchAllBills();
		return billsList;
	}

	public List<BillsBean> deleteBill(BigDecimal bill_id) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "DELETE from bills  where bill_id = " + bill_id;
		List<BillsBean> billsList = new ArrayList<BillsBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		billsList = fetchAllBills();
		return billsList;
	}

	public int genRandomInt() {

		Random rnd = new Random();
		return rnd.nextInt(30);

	}

}
