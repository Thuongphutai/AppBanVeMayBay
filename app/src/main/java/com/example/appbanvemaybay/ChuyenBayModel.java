package com.example.appbanvemaybay;

public class ChuyenBayModel {
    String id,DiemDen,DiemDi,endTime,price,firstTime,Ngay;

    public ChuyenBayModel() {
    }

    public ChuyenBayModel(String id, String diemDen, String diemDi, String endTime, String price, String firstTime, String ngay) {
        this.id = id;
        DiemDen = diemDen;
        DiemDi = diemDi;
        this.endTime = endTime;
        this.price = price;
        this.firstTime = firstTime;
        Ngay = ngay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiemDen() {
        return DiemDen;
    }

    public void setDiemDen(String diemDen) {
        DiemDen = diemDen;
    }

    public String getDiemDi() {
        return DiemDi;
    }

    public void setDiemDi(String diemDi) {
        DiemDi = diemDi;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }
}
