/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author uyenc
 */
public class Products {
    private int product_id;
    private String product_name;
      private int model_year;
    private double price;
    private String brand_name, category_name;
   private int status;

    public Products() {
    }

    public Products(int product_id, String product_name, int model_year, double list_price, String brand_name, String category_name) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.model_year = model_year;
        this.price = list_price;
        this.brand_name = brand_name;
        this.category_name = category_name;
    }

    public Products(int product_id, String product_name, double list_price, int status) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = list_price;
        this.status = status;
    }
    
   
    @Override
    public String toString() {
        return "Products{" + "product_id=" + product_id + ", product_name=" + product_name + ", model_year=" + model_year + ", list_price=" + price + ", brand_name=" + brand_name + ", category_name=" + category_name + '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



 

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getModel_year() {
        return model_year;
    }

    public void setModel_year(int model_year) {
        this.model_year = model_year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    
    
}
