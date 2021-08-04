package org.kwp.Servicing;

import java.math.BigDecimal;
import java.sql.Date;

public class ServicingBean {

    private BigDecimal servicing_id;
    private BigDecimal servicing_service_id;
    private BigDecimal servicing_employee_id;
    private BigDecimal employee_id;
    private Date servicing_date;
    private String servicing_status;
    private String employee_name;
    private String service_name;

    public BigDecimal getServicing_id() {
        return servicing_id;
    }

    public void setServicing_id(BigDecimal servicing_id) {
        this.servicing_id = servicing_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public BigDecimal getServicing_service_id() {
        return servicing_service_id;
    }

    public void setServicing_service_id(BigDecimal servicing_service_id) {
        this.servicing_service_id = servicing_service_id;
    }

    public BigDecimal getServicing_employee_id() {
        return servicing_employee_id;
    }

    public void setServicing_employee_id(BigDecimal servicing_employee_id) {
        this.servicing_employee_id = servicing_employee_id;
    }

    public Date getServicing_date() {
        return servicing_date;
    }

    public void setServicing_date(Date servicing_date) {
        this.servicing_date = servicing_date;
    }

    public String getServicing_status() {
        return servicing_status;
    }

    public void setServicing_status(String servicing_status) {
        this.servicing_status = servicing_status;
    }

    public BigDecimal getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(BigDecimal employee_id) {
        this.employee_id = employee_id;
    }

}