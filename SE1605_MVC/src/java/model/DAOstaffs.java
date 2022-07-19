/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Orders;
import entity.Staffs;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DAOstaffs extends ConnectDB {

    public int addStaff(Staffs staff) {
        int n = 0;
        String sql = "INSERT INTO [staffs]\n"
                + "           ([staff_id]\n"
                + "           ,[first_name]\n"
                + "           ,[last_name]\n"
                + "           ,[email]\n"
                + "           ,[phone]\n"
                + "           ,[active]\n"
                + "           ,[store_id]\n"
                + "           ,[manager_id])\n"
                + "     VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, staff.getStaff_id());
            pre.setString(2, staff.getFirst_name());
            pre.setString(3, staff.getLast_name());
            pre.setString(4, staff.getEmail());
            pre.setString(5, staff.getPhone());
            pre.setInt(6, staff.getActive());
            pre.setInt(7, staff.getStore_id());
            pre.setInt(8, staff.getManager_id());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;

    }

    public int updateStaff(Staffs sf) {
        int n = 0;
        String sql = "update Staffs set "
                + "[first_name]=?,[last_name]=?,[email]=?,"
                + "[phone]=?,[active]=?,[store_id]=?,[manager_id]=? "
                + "where [staff_id]=? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //set value for ?
            //? index start 1
            //pre.setDataType(index,value);
            //dataType of dataType of field
            pre.setString(1, sf.getFirst_name());
            pre.setString(2, sf.getLast_name());
            pre.setString(3, sf.getEmail());
            pre.setString(4, sf.getPhone());
            pre.setInt(5, sf.getActive());
            pre.setInt(6, sf.getStore_id());
            pre.setInt(7, sf.getManager_id());
            pre.setInt(8, sf.getStaff_id());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deleteStaff(int id) {
        int n = 0;
        String sql = "delete from Staffs where staff_id='" + id + "'";
        //check foreign key constrain
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public boolean isExistAdmin(String username, String password) {
        String sql = "select * from staffs where username = '" + username + "' and password = '" + password + "'";
        ResultSet rs = getData(sql);
        try {
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ResultSet getAdminByUsername(String username) {
        String sql = "select * from staffs where username = '" + username + "'";
        ResultSet rs = getData(sql);
        return rs;
    }

    public Vector<Staffs> listAll(String sql) {
        Vector<Staffs> vector = new Vector<Staffs>();
//        String sql = "select * from staffs";
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int staff_id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                int active = rs.getInt(6);
                int store_id = rs.getInt(7);
                int manager_id = rs.getInt(8);
                Staffs staff = new Staffs(staff_id, first_name, last_name, email, phone, active, store_id, manager_id);
//                System.out.println(staff);
                vector.add(staff);
            }
            System.out.println(vector);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public void displayStaffWithOrderOnStaffID() {
        String sql = "select * from staffs "
                + "inner join orders "
                + "on staffs.staff_id = orders.staff_id";
        int count = 0;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int staff_id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                int active = rs.getInt(6);
                int store_id = rs.getInt(7);
                int manager_id = rs.getInt(8);
                Staffs staff = new Staffs(staff_id, first_name, last_name, email, phone, active, store_id, manager_id);

                int order_id = rs.getInt(9);
                int customer_id = rs.getInt(10);
                int order_status = rs.getInt(11);
                String order_date = rs.getString(12);
                String required_date = rs.getString(13);
                String shipped_date = rs.getString(14);
                count++;
                Orders od = new Orders(order_id, customer_id, order_status, order_date, required_date, shipped_date, store_id, staff_id);
                System.out.println(count + " " + staff.toString() + od.toString());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        DAOstaffs staff = new DAOstaffs();
//        int n = staff.addStaff(new Staffs(11,"Hai","Phong ko","mnhw@gmail.com","0494934",8,1,2));
//        if (n > 0) {
//            System.out.println("succsesse");
//        }
        staff.listAll("select * from staffs");
//        staff.displayStaffWithOrderOnStaffID();
    }

}
