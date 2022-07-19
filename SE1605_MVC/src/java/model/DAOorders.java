/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Customers;
import entity.Orders;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DAOorders extends ConnectDB {

    public int addOrders(Orders o) {
        int n = 0;
        String sql = "insert into orders(order_id,customer_id,order_status,order_date,required_date,shipped_date,store_id,staff_id)"
                + " values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareCall(sql);
            //set value for ?
            //? index start 1
            //pre.setDataType(index,value);
            //dataType of dataType of field
            pre.setInt(1, o.getOrder_id());
            pre.setInt(2, o.getCustomer_id());
            pre.setInt(3, o.getOrder_status());
            pre.setString(4, o.getOrder_date());
            pre.setString(5, o.getRequired_date());
            pre.setString(6, o.getShipped_date());
            pre.setInt(7, o.getStore_id());
            pre.setInt(8, o.getStaff_id());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Orders> listAll(String sql) {
        //  String sql = "select * from orders";
        Vector<Orders> vector = new Vector<Orders>();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int order_id = rs.getInt(1);
                int customer_id = rs.getInt(2);
                int order_status = rs.getInt(3);
                String order_date = rs.getString(4);
                String required_date = rs.getString(5);
                String shipped_date = rs.getString(6);
                int store_id = rs.getInt(7);
                int staff_id = rs.getInt(8);
                String cusName = rs.getString(9);
                                Double price = rs.getDouble(10);

                Orders od = new Orders(order_id, customer_id, order_status, order_date, required_date, shipped_date, store_id, staff_id, cusName, price);
                //System.out.println(od);
                vector.add(od);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<Orders> listAllWithCusName() {
        String sql = "select od.*,(cus.first_name + ' ' + cus.last_name) name, sum(odI.list_price) total from orders od \n"
                + "inner join customers cus on cus.customer_id = od.customer_id\n"
                + "inner join order_items odI on od.order_id = odI.order_id\n"
                + "group by od.order_id,od.customer_id,od.order_status,od.order_date,\n"
                + "od.required_date,od.shipped_date,od.store_id,od.staff_id,cus.first_name,cus.last_name\n"
                + "order by order_id";
        Vector<Orders> vector = new Vector<Orders>();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int order_id = rs.getInt(1);
                int customer_id = rs.getInt(2);
                int order_status = rs.getInt(3);
                String order_date = rs.getString(4);
                String required_date = rs.getString(5);
                String shipped_date = rs.getString(6);
                int store_id = rs.getInt(7);
                int staff_id = rs.getInt(8);
                String cusName = rs.getString(9);
                Double price = rs.getDouble(10);
                Orders od = new Orders(order_id, customer_id, order_status, order_date, required_date, shipped_date, store_id, staff_id, cusName, price);
                //System.out.println(od);
                vector.add(od);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public int updateOrder(Orders o) {
        int n = 0;
        String sql = "update Orders set "
                + "[customer_id]=?,[order_status]=?,[order_date]=?,"
                + "[required_date]=?,[shipped_date]=?,[store_id]=?,[staff_id]=? "
                + "where [order_id]=? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //set value for ?
            //? index start 1
            //pre.setDataType(index,value);
            //dataType of dataType of field           
            pre.setInt(1, o.getCustomer_id());
            pre.setInt(2, o.getOrder_status());
            pre.setString(3, o.getOrder_date());
            pre.setString(4, o.getRequired_date());
            pre.setString(5, o.getShipped_date());
            pre.setInt(6, o.getStore_id());
            pre.setInt(7, o.getStaff_id());
            pre.setInt(8, o.getOrder_id());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deleteOrder(int id) {
        int n = 0;
        String sql = "delete from Orders where order_id='" + id + "'";
        //check foreign key constrain
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public void displayOrderWithCustomer() {
        String sql = "select * from Orders "
                + "inner join Customers "
                + "on Customers.customer_id = Orders.customer_id";

        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int oID = rs.getInt(1);
                int cuID = rs.getInt(2);
                int oStatus = rs.getInt(3);
                String oDate = rs.getString(4);
                String reDate = rs.getString(5);
                String shipDate = rs.getString(6);
                int sID = rs.getInt(7);
                int sfID = rs.getInt(8);
                Orders o = new Orders(oID, cuID, oStatus, oDate,
                        reDate, shipDate, sID, sfID);

                String cuFirst = rs.getString(9);
                String cuLast = rs.getString(10);
                String phone = rs.getString(11);
                String email = rs.getString(12);
                String street = rs.getString(13);
                String city = rs.getString(14);
                String state1 = rs.getString(15);
                String zip_code = rs.getString(16);
                Customers cu = new Customers(cuID, cuFirst, cuLast, phone,
                        email, street, city, state1, zip_code);
                System.out.println(o.toString() + cu.toString());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        DAOorders dao = new DAOorders();
        int n = dao.addOrders(new Orders(2493, 12, 6, "03/13/1999", "05/12/2024", "01/17/2022", 4, 113));
        if (n > 0) {
            System.out.println("inserted");
        }
//        dao.displayOrderWithCustomer();
    }
}
