/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author nanht
 */
public class Staffs {

    private int staff_id;
    private String first_name, last_name, email, phone, username, password;
    private int active, store_id, manager_id;

    public Staffs() {
    }

    @Override
    public String toString() {
        return "Staffs{" + "staff_id=" + staff_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", phone=" + phone + ", active=" + active + ", store_id=" + store_id + ", manager_id=" + manager_id + '}';
    }

    public Staffs(int staff_id, String first_name, String last_name, String email, String phone, int active, int store_id, int manager_id) {
        this.staff_id = staff_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.active = active;
        this.store_id = store_id;
        this.manager_id = manager_id;
    }

    public Staffs(int staff_id, String first_name, String last_name, String email, String phone, int active, int store_id, int manager_id, String username, String password) {
        this.staff_id = staff_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.active = active;
        this.store_id = store_id;
        this.manager_id = manager_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

}
