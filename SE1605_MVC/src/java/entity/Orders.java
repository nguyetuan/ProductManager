/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class Orders {

    private int order_id, customer_id, order_status;
    private String order_date, required_date, shipped_date, customer_name;
    private int store_id, staff_id;
    private Double totalPrice;

    public Orders() {
    }

    public Orders(int order_id, int customer_id, int order_status, String order_date, String required_date, String shipped_date, int store_id, int staff_id) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_status = order_status;
        this.order_date = order_date;
        this.required_date = required_date;
        this.shipped_date = shipped_date;
        this.store_id = store_id;
        this.staff_id = staff_id;
    }

    public Orders(int order_id, int customer_id, int order_status, String order_date, String required_date, String shipped_date, int store_id, int staff_id, String customer_name, Double totalPrice) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_status = order_status;
        this.order_date = order_date;
        this.required_date = required_date;
        this.shipped_date = shipped_date;
        this.store_id = store_id;
        this.staff_id = staff_id;
        this.customer_name = customer_name;
        this.totalPrice = totalPrice;

    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    
    
    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getRequired_date() {
        return required_date;
    }

    public void setRequired_date(String required_date) {
        this.required_date = required_date;
    }

    public String getShipped_date() {
        return shipped_date;
    }

    public void setShipped_date(String shipped_date) {
        this.shipped_date = shipped_date;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

}
