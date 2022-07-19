/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Stocks;
import entity.Stores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DAOstores extends ConnectDB {

    public int addStore(Stores store) {
        int n = 0;
        String sql = "INSERT INTO [stores]\n"
                + "           ([store_id]\n"
                + "           ,[store_name]\n"
                + "           ,[phone]\n"
                + "           ,[email]\n"
                + "           ,[street]\n"
                + "           ,[city]\n"
                + "           ,[state]\n"
                + "           ,[zip_code])\n"
                + "     VALUES(?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, store.getStore_id());
            pre.setString(2, store.getStore_name());
            pre.setString(3, store.getPhone());
            pre.setString(4, store.getEmail());
            pre.setString(5, store.getStreet());
            pre.setString(6, store.getCity());
            pre.setString(7, store.getState());
            pre.setString(8, store.getZip_code());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateStore(Stores s) {
        int n = 0;
        String sql = "update Stores set "
                + "[store_name]=?,[phone]=?,[email]=?,"
                + "[street]=?,[city]=?,[state]=?,[zip_code]=? "
                + "where [store_id]=? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //set value for ?
            //? index start 1
            //pre.setDataType(index,value);
            //dataType of dataType of field
            pre.setString(1, s.getStore_name());
            pre.setString(2, s.getPhone());
            pre.setString(3, s.getEmail());
            pre.setString(4, s.getStreet());
            pre.setString(5, s.getCity());
            pre.setString(6, s.getState());
            pre.setString(7, s.getZip_code());
            pre.setInt(8, s.getStore_id());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int removeStore(int id) {
        int n = 0;
        String sql = "delete from Stores where store_id='" + id + "'";
        //check foreign key constrain
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Stores> listAll(String sql) {
        Vector<Stores> vector = new Vector<Stores>();
//        String sql = "select * from stores";
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int store_id = rs.getInt(1);
                String store_name = rs.getString(2);
                String phone = rs.getString(3);
                String email = rs.getString(4);
                String street = rs.getString(5);
                String city = rs.getString(6);
                String state = rs.getString(7);
                String zip_code = rs.getString(8);
                Stores store = new Stores(store_id, store_name, phone, email, street, city, state, zip_code);
                vector.add(store);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOstores store = new DAOstores();
//        int n = store.addStore(new Stores(6, "Werod Ghita", "0638273443", "werodghita@gmail.com", "653 Fijit Onasa", "Multiple World", "SP", "84732"));
//        if (n > 0) {
//            System.out.println("DAO store success");
//        }
//        store.listAll();
    }
}
