/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Products;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOproducts extends ConnectDB {

    public int addProducts(Products p) {
        int n = 0;
        String sql = "insert into products(product_id,product_name,model_year,list_price,brand_name,category_name)"
                + " values(?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //set value for ?
            //? index start 1
            //pre.setDataType(index,value);
            //dataType of dataType of field
            pre.setInt(1, p.getProduct_id());
            pre.setString(2, p.getProduct_name());
            pre.setInt(3, p.getModel_year());
            pre.setDouble(4, p.getPrice());
            pre.setString(5, p.getBrand_name());
            pre.setString(6, p.getCategory_name());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateProduct(Products p) {
        int n = 0;
        String sql = "update Products set "
                + "[product_name]=?,[model_year]=?,[list_price]=?,"
                + "[brand_name]=?,[category_name]=? "
                + "where [product_id]=? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //set value for ?
            //? index start 1
            //pre.setDataType(index,value);
            //dataType of dataType of field
            pre.setString(1, p.getProduct_name());
            pre.setInt(2, p.getModel_year());
            pre.setDouble(3, p.getPrice());
            pre.setString(4, p.getBrand_name());
            pre.setString(5, p.getCategory_name());
            pre.setInt(6, p.getProduct_id());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Products> getProductWithCategoryName(String name) {
        Vector<Products> vector = listAll("select * from products where category_name = '" + name + "'");
        return vector;
    }

    public Vector<Products> getProductWithStatus1() {
        Vector<Products> vector = new Vector<Products>();
//        String sql = "select * from products";
        try {
            ResultSet rs = getData("select distinct pro.product_id, pro.product_name, pro.list_price, o.order_status from orders o \n"
                    + "inner join order_items od on o.order_id = od.order_id and o.order_status =1 \n"
                    + "inner join products pro on pro.product_id = od.product_id");
            while (rs.next()) {
                int product_id = rs.getInt(1);
                String product_name = rs.getString(2);
                double list_price = rs.getDouble(3);
                int status = rs.getInt(4);
                Products pd = new Products(product_id, product_name, list_price, status);
//                System.out.println(pd);
                vector.add(pd);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isIntNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Vector<Products> getProductWithStatus1AndProductName(String name) {
        Vector<Products> vector = new Vector<Products>();
        double num = -1;
        if (isNumeric(name)) {
            num = Double.parseDouble(name);
        }
//        String sql = "select * from products";
        try {
            ResultSet rs = getData("select pro.product_id, pro.product_name, pro.list_price, o.order_status from orders o \n"
                    + "inner join order_items od on o.order_id = od.order_id and o.order_status =1\n"
                    + "inner join products pro on pro.product_id = od.product_id \n"
                    + "and (pro.product_name like '%" + name + "%' or pro.list_price = " + num + ")");
            while (rs.next()) {
                int product_id = rs.getInt(1);
                String product_name = rs.getString(2);
                double list_price = rs.getDouble(3);
                int status = rs.getInt(4);
                Products pd = new Products(product_id, product_name, list_price, status);
//                System.out.println(pd);
                vector.add(pd);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<Products> getProductWithStatus1AndCategoryName(String category) {
        Vector<Products> vector = new Vector<Products>();
//        String sql = "select * from products";
        try {
            ResultSet rs = getData("select pro.product_id, pro.product_name, pro.list_price, o.order_status from orders o \n"
                    + "inner join order_items od on o.order_id = od.order_id and o.order_status =1 \n"
                    + "inner join products pro on pro.product_id = od.product_id and pro.category_name = '" + category + "'");
            while (rs.next()) {
                int product_id = rs.getInt(1);
                String product_name = rs.getString(2);
                double list_price = rs.getDouble(3);
                int status = rs.getInt(4);
                Products pd = new Products(product_id, product_name, list_price, status);
//                System.out.println(pd);
                vector.add(pd);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public ResultSet getProductByProductId(String id) {
        String sql = "select * from products where product_id = " + id;
        ResultSet rs = getData(sql);
        return rs;
    }

    public Vector<Products> getAdminProductByProductName(String name) {
        Vector<Products> vector = new Vector<Products>();
//        String sql = "select * from products";
        try {
            double num = -1;
            if (isIntNumeric(name)) {
                num = Integer.parseInt(name);
            }
            ResultSet rs = getData("select * from products where product_id = " + num + " or product_name like '%" + name + "%'");
            while (rs.next()) {
                int product_id = rs.getInt(1);
                String product_name = rs.getString(2);
                int model_year = rs.getInt(3);
                double list_price = rs.getDouble(4);
                String brand_name = rs.getString(5);
                String category_name = rs.getString(6);
                Products pd = new Products(product_id, product_name, model_year, list_price, brand_name, category_name);
                vector.add(pd);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public ResultSet getCategory() {
        String sql = "select distinct category_name from products";
        ResultSet rs = getData(sql);
        return rs;
    }

    public int deleteProduct(int id) {
        int n = 0;
        String sql = "delete from Products where product_id='" + id + "'";
        //check foreign key constrain
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    //Search Product by Name
    public Vector<Products> searchName(String name) {
        Vector<Products> vector = new Vector<Products>();
        String sql = "select * from Products where product_name='" + name + "'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                //get product
                int pID = rs.getInt("product_id");
                String pName = rs.getString(2);
                int model_year = rs.getInt(3);
                double list_price = rs.getDouble(4);
                String bName = rs.getString(5);
                String cName = rs.getString(6);
                Products p = new Products(pID, pName, model_year, list_price,
                        bName, cName);
                vector.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    //Search Product from X to Y price
    public Vector<Products> searchPrice(double from, double to) {
        Vector<Products> vector = new Vector<Products>();
        String sql = "select * from Products where list_price between " + from
                + " and " + to;
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int pID = rs.getInt("product_id");
                String pName = rs.getString(2);
                int model_year = rs.getInt(3);
                double list_price = rs.getDouble(4);
                String bName = rs.getString(5);
                String cName = rs.getString(6);
                Products p = new Products(pID, pName, model_year, list_price,
                        bName, cName);
                vector.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<Products> listAll(String sql) {
        Vector<Products> vector = new Vector<Products>();
//        String sql = "select * from products";
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int product_id = rs.getInt(1);
                String product_name = rs.getString(2);
                int model_year = rs.getInt(3);
                double list_price = rs.getDouble(4);
                String brand_name = rs.getString(5);
                String category_name = rs.getString(6);
                Products pd = new Products(product_id, product_name, model_year, list_price, brand_name, category_name);
                vector.add(pd);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOproducts dao = new DAOproducts();
        Vector<Products> vector = dao.getProductWithStatus1();
    }
}
