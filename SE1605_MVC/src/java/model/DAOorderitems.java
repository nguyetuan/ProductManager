/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.OrderItems;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DAOorderitems extends ConnectDB {

    public int addOrderItems(OrderItems oi) {
        int n = 0;
        String sql = "INSERT INTO [order_items]\n"
                + "           ([order_id]\n"
                + "           ,[item_id]\n"
                + "           ,[product_id]\n"
                + "           ,[quantity]\n"
                + "           ,[list_price]\n"
                + "           ,[discount])\n"
                + "     VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //set value for ?
            //? index start 1
            //pre.setDataType(index,value);
            //dataType of dataType of field
            pre.setInt(1, oi.getOrder_id());
            pre.setInt(2, oi.getItem_id());
            pre.setInt(3, oi.getProduct_id());
            pre.setInt(4, oi.getQuantity());
            pre.setDouble(5, oi.getList_price());
            pre.setDouble(6, oi.getDiscount());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deleteCustomer(int id) {
        int n = 0;
        String sql = "delete from customers where \n"
                + "customer_id = " + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector listAll(String sql) {
        Vector<OrderItems> vector = new Vector<OrderItems>();
//        String sql = "select * from order_items";
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int order_id = rs.getInt(1);
                int item_id = rs.getInt(2);
                int product_id = rs.getInt(3);
                int quantity = rs.getInt(4);
                double list_price = rs.getDouble(5);
                double discount = rs.getDouble(6);

                OrderItems odi = new OrderItems(order_id, item_id, product_id, quantity, list_price, discount);
                vector.add(odi);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public int updateOrderItem(OrderItems oi) {
        int n = 0;
        String sql = "update Order_Items set "
                + "[order_id]=?,[product_id]=?,[quantity]=?,"
                + "[list_price]=?,[discount]=? "
                + "where [item_id]=? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //set value for ?
            //? index start 1
            //pre.setDataType(index,value);
            //dataType of dataType of field
            pre.setInt(1, oi.getOrder_id());
            pre.setInt(2, oi.getProduct_id());
            pre.setInt(3, oi.getQuantity());
            pre.setDouble(4, oi.getList_price());
            pre.setDouble(5, oi.getDiscount());
            pre.setInt(6, oi.getItem_id());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateQuantityOfOrderItem(OrderItems oi) {
        int n = 0;
        String sql = "update order_items set quantity = ? where order_id = ? and product_id = ? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, oi.getQuantity());
            pre.setInt(2, oi.getOrder_id());
            pre.setInt(3, oi.getProduct_id());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public static void main(String[] args) {
        DAOorderitems dao = new DAOorderitems();
//       Vector<OrderItems> vector = dao.listAll("select * from order_items where order_id = " + 1671);
//        for (OrderItems orderItems : vector) {
//            System.out.println(orderItems.getOrder_id());
//dao.addOrderItems(new OrderItems(1616, 1, 7, 2, 0.4, 0.2));
//        }
    }
}
