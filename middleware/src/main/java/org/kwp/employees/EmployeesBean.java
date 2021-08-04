package org.kwp.employees;

import java.math.BigDecimal;

public class EmployeesBean {

    private BigDecimal employee_id;
    private String employee_name;
    private String employee_phone_number;
    private String employee_rank;
    private String employee_email_address;

    public String getEmployee_name() {
        return employee_name;
    }


    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public BigDecimal getEmployee_id() {
        return employee_id;
    }


    public void setEmployee_id(BigDecimal employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_rank() {
        return employee_rank;
    }

    public void setEmployee_rank(String employee_rank) {
        this.employee_rank = employee_rank;
    }

    public String getEmployee_phone_number() {
        return employee_phone_number;
    }

    public void setEmployee_phone_number(String employee_phone_number) {
        this.employee_phone_number = employee_phone_number;
    }


    public String getEmployee_email_address() {
        return employee_email_address;
    }


    public void setEmployee_email_address(String employee_email_address) {
        this.employee_email_address = employee_email_address;
    }

}