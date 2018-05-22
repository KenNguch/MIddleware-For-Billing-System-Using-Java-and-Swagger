            package org.kwp.billing;

            import java.math.BigDecimal;

            import org.kwp.SmsSender.SmsRestController;
            import org.kwp.emailSender.EmailsController;
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
            public class 		BillingDAO {

                @Autowired
                DataSource dataSource;
                SmsRestController smsRestController;
                EmailsController emailsController;

                public List<BillingBean> fetchAllBillings() throws SQLException {
                    PreparedStatement cst = null;

                    Connection conn = null;

                    String selectSQL = "SELECT * from billing";
                    List<BillingBean> billingList = new ArrayList<BillingBean>();

                    try {

                        conn = dataSource.getConnection();
                        cst = conn.prepareStatement(selectSQL);

                        ResultSet rs = cst.executeQuery();
                        while (rs.next()) {

                            BillingBean billing = new BillingBean();
                            billing.setBilling_id(rs.getBigDecimal("billing_id"));
                            billing.setBilling_bill_id(rs.getBigDecimal("billing_bill_id"));
                            billing.setBilling_customer_connection_number(rs.getBigDecimal("billing_customer_connection_number"));
                            billing.setBilling_date(rs.getDate("billing_date"));

                            billingList.add(billing);

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        conn.close();
                    }

                    return billingList;
                }

                public List<BillingBean> fetchAllBillingsForACustomer(BigDecimal billing_customer_connection_number) throws SQLException {
                    PreparedStatement cst = null;

                    Connection conn = null;

                    String selectSQL = "SELECT billing_bill_id,customer_name,bill_name,billing_customer_connection_number,billing_date from billing,bills,customers where billing_bill_id = bill_id AND billing_customer_connection_number ="
                            + billing_customer_connection_number;
                    List<BillingBean> billingList = new ArrayList<BillingBean>();

                    try {

                        conn = dataSource.getConnection();
                        cst = conn.prepareStatement(selectSQL);

                        ResultSet rs = cst.executeQuery();
                        while (rs.next()) {

                            BillingBean billing = new BillingBean();
                            billing.setBilling_bill_id(rs.getBigDecimal("billing_bill_id"));
                            billing.setCustomer_name(rs.getString("customer_name"));
                            billing.setBill_name(rs.getString("bill_name"));
                            billing.setBilling_customer_connection_number(rs.getBigDecimal("billing_customer_connection_number"));
                            billing.setBilling_date(rs.getDate("billing_date"));

                            billingList.add(billing);

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        conn.close();
                    }
                    return billingList;
                }

                public List<BillingBean> createBilling(BigDecimal billing_id, BigDecimal billing_bill_id,
                        BigDecimal billing_custumer_connection_number, Date billing_date) throws SQLException {
                    PreparedStatement cst = null;

                    Connection conn = null;

                    String selectSQL = "INSERT INTO billing(billing_id,billing_bill_id,billing_customer_connection_number,billing_date) values  ("
                            + genRandomInt() + "," + billing_bill_id + "," + billing_custumer_connection_number + ",'"
                            + currentdate() + "')";

                    List<BillingBean> billingList = new ArrayList<BillingBean>();

                    try {

                        conn = dataSource.getConnection();

                        cst = conn.prepareStatement(selectSQL);

                        cst.execute();

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        conn.close();
                    }

                    billingList = fetchAllBillings();

                    return billingList;
                }

                public List<BillingBean> updateBilling(BigDecimal billing_id, BigDecimal billing_bill_id,
                        BigDecimal billing_custumer_connection_number, Date billing_date) throws SQLException {
                    PreparedStatement cst = null;

                    Connection conn = null;

                    String selectSQL = "UPDATE billing set billing_bill_id = " + billing_bill_id
                            + ",billing_customer_connection_number = " + billing_custumer_connection_number + ",billing_date = '"
                            + currentdate() + "' where billing_id=" + billing_id + "";
                    List<BillingBean> billingList = new ArrayList<BillingBean>();

                    try {

                        conn = dataSource.getConnection();

                        cst = conn.prepareStatement(selectSQL);

                        cst.execute();

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        conn.close();
                    }
                    billingList = fetchAllBillings();

                    return billingList;
                }

                public List<BillingBean> deleteBilling(BigDecimal billing_id) throws SQLException {
                    PreparedStatement cst = null;

                    Connection conn = null;

                    String selectSQL = "DELETE from bills  where billing_id =" + billing_id + "";
                    List<BillingBean> billingList = new ArrayList<BillingBean>();

                    try {

                        conn = dataSource.getConnection();

                        cst = conn.prepareStatement(selectSQL);

                        cst.execute();

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        conn.close();
                    }
                    billingList = fetchAllBillings();
                    return billingList;
                }

                public int genRandomInt() {

                    Random rnd = new Random();
                    return rnd.nextInt(30);

                }

                public Date currentdate() 
                {
                    Calendar calendar = Calendar.getInstance();

                    // get a java date (java.util.Date) from the Calendar instance.
                    // this java date will represent the current date, or "now".
                    java.util.Date currentDate = calendar.getTime();

                    // now, create a java.sql.Date from the java.util.Date
                    java.sql.Date date = new java.sql.Date(currentDate.getTime());

                    return date;
                }

            }
