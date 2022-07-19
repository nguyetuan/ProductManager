package model;

import entity.Customers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOcustomers extends ConnectDB {

    public int addCustomer(Customers cus) {
        int n = 0;
        String sql = "INSERT INTO [customers]"
                + "           ([customer_id]"
                + "           ,[first_name]"
                + "           ,[last_name]"
                + "           ,[phone]"
                + "           ,[email]"
                + "           ,[street]"
                + "           ,[city]"
                + "           ,[state]"
                + "           ,[zip_code] "
                + "           ,[username]\n"
                + "           ,[password])"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //set value for ?
            // ? index start 1
            pre.setInt(1, cus.getCustomer_id());
            pre.setString(2, cus.getFirst_name());
            pre.setString(3, cus.getLast_name());
            pre.setString(4, cus.getPhone());
            pre.setString(5, cus.getEmail());
            pre.setString(6, cus.getStreet());
            pre.setString(7, cus.getCity());
            pre.setString(8, cus.getState());
            pre.setString(9, cus.getZip_code());
            pre.setString(10, cus.getUsername());
            pre.setString(11, cus.getPassword());

            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateCustomer(Customers cus) {
        int n = 0;
        String sql = "UPDATE [dbo].[customers]\n"
                + "   SET "
                + "      [first_name] = ?"
                + "      ,[last_name] = ?"
                + "      ,[phone] = ?"
                + "      ,[email] = ?"
                + "      ,[street] = ?"
                + "      ,[city] = ?"
                + "      ,[state] = ?"
                + "      ,[zip_code] = ?"
                + " WHERE [customer_id] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //set value for ?
            // ? index start 1
            pre.setInt(9, cus.getCustomer_id());
            pre.setString(1, cus.getFirst_name());
            pre.setString(2, cus.getLast_name());
            pre.setString(3, cus.getPhone());
            pre.setString(4, cus.getEmail());
            pre.setString(5, cus.getStreet());
            pre.setString(6, cus.getCity());
            pre.setString(7, cus.getState());
            pre.setString(8, cus.getZip_code());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int changePhone(String phone, int id) {
        int n = 0;
        String sql = "update customers set phone = ? where customer_id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, phone);
            pre.setInt(2, id);
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

    public boolean isExistUser(String username, String password) {
        String sql = "select * from Customers where username = '" + username + "' and password = '" + password + "'";
        ResultSet rs = getData(sql);
        try {
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ResultSet getCustomerById(int id) {
        String sql = "select * from Customers where customer_id = " + id;
        ResultSet rs = getData(sql);
        return rs;
    }

    public ResultSet getCustomerByUsername(String username) {
        String sql = "select c.username, c.password from Customers c where username = '" + username + "'";
        ResultSet rs = getData(sql);
        return rs;
    }
        public ResultSet getAllCustomerByUsername(String username) {
        String sql = "select * from customers where username = '"+username+"'";
        ResultSet rs = getData(sql);
        return rs;
    }

    public Vector<Customers> getCustomerByName(String name) {
        Vector<Customers> vector = new Vector<Customers>();
        String sql = "select * from customers where first_name = '" + name + "' or last_name = '" + name + "' or (first_name + ' ' + last_name) = '" + name + "'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                //rs.getdatatype(fieldname|index =1);
                int cusID = rs.getInt(1);
                String cusName = rs.getString(2);
                String lastName = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                String street = rs.getString(6);
                String city = rs.getString(7);
                String state1 = rs.getString(8);
                String zip_code = rs.getString(9);
                Customers cus = new Customers(cusID, cusName, lastName, phone, email, street, city, state1, zip_code);
                vector.add(cus);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<Customers> getCustomerByCity(String city) {
        Vector<Customers> vector = new Vector<Customers>();
        String sql = "select * from Customers where city = '" + city + "'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                //rs.getdatatype(fieldname|index =1);
                int cusID = rs.getInt("customer_id");
//        int cusID = rs.getInt(1);
                String cusName = rs.getString(2);
//String cusName = rs.getString("first_name");
                String lastName = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                String street = rs.getString(6);
                String state1 = rs.getString(8);
                String zip_code = rs.getString(9);
                Customers cus = new Customers(cusID, cusName, lastName, phone, email, street, city, state1, zip_code);
                vector.add(cus);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<Customers> listAll(String sql) {
        Vector<Customers> vector = new Vector<Customers>();

//        String sql = "select * from customers";
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                //rs.getdatatype(fieldname|index =1);
                int cusID = rs.getInt(1);
                String FirstName = rs.getString(2);
                String lastName = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                String street = rs.getString(6);
                String city = rs.getString(7);
                String state1 = rs.getString(8);
                String zip_code = rs.getString(9);
                Customers cus = new Customers(cusID, FirstName, lastName, phone, email, street, city, state1, zip_code);
//                System.out.println(cus);
                vector.add(cus);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOcustomers dao = new DAOcustomers();
     int n =   dao.deleteCustomer(4);
     if(n == 0){
         System.out.println("cant delete");
     }

    }
}
