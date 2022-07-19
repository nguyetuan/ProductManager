/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Stocks;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DAOstocks extends ConnectDB {

    public int addStock(Stocks stock) {
        int n = 0;
        String sql = "INSERT INTO [stocks]\n"
                + "           ([store_id]\n"
                + "           ,[product_id]\n"
                + "           ,[quantity])\n"
                + "     VALUES(?,?,?)";

        try {

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, stock.getStore_id());
            pre.setInt(2, stock.getProduct_id());
            pre.setInt(3, stock.getQuantity());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Stocks> listAll(String sql) {
        Vector<Stocks> vector = new Vector<Stocks>();
//        String sql = "select * from stocks";
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int store_id = rs.getInt(1);
                int product_id = rs.getInt(2);
                int quantity = rs.getInt(3);
                Stocks stock = new Stocks(store_id, product_id, quantity);
                vector.add(stock);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public int updateStock(Stocks sk) {
        int n = 0;
        String sql = "update Stocks set [quantity]=? where [store_id]=? and [product_id]=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //set value for ?
            //? index start 1
            //pre.setDataType(index,value);
            //dataType of dataType of field
            pre.setInt(1, sk.getQuantity());
            pre.setInt(2, sk.getStore_id());
            pre.setInt(3, sk.getProduct_id());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deleteStock(int id) {
        int n = 0;
        String sql = "delete from Stocks where store_id='" + id + "'";
        //check foreign key constrain
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public static void main(String[] args) {
        DAOstocks stock = new DAOstocks();
//        int n = stock.addStock(new Stocks(5, 12, 88));
//        stock.listAll();
stock.updateStock(new Stocks(1, 2, 8));
    }

}
