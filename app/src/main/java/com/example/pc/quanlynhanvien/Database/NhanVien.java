package com.example.pc.quanlynhanvien.Database;

/**
 * Created by PC on 4/18/2018.
 */

public class NhanVien {
    private int id;
    private String code;
    private String name;
    private String email;
    private String phone;
    private String address;

    public NhanVien() {
    }

    public NhanVien(String code, String name, String email, String phone, String address) {
        this.code = code;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public NhanVien(int id, String code, String name, String email, String phone, String address) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
